package ao.cinapse.recicla_me.security;

import ao.cinapse.recicla_me.http.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class ConfiguracaoSeguranca
{
    @Autowired
    private UsuarioFilterMiddleware usuarioFilterMiddleware;




    @Bean
    public CorsConfigurationSource habilitarCors()
    {
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedOrigins(Arrays.asList("*"));
        cors.setAllowedHeaders(Arrays.asList("*"));
        cors.setAllowedHeaders(Arrays.asList("GET", "POST", "DELETE", "PUT", "PATCH", "HEAD"));

        UrlBasedCorsConfigurationSource register = new UrlBasedCorsConfigurationSource();
        register.registerCorsConfiguration("/**", cors);
        return register;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception
    {
        security
                .csrf( crsf -> crsf.disable())
                .authorizeHttpRequests( authorize -> {
                    authorize.requestMatchers("/auth/**").permitAll();
                    authorize.anyRequest().authenticated();
                })
                .exceptionHandling( exceptionHandling -> exceptionHandling.accessDeniedPage("/auth/unauthorized"))
                .httpBasic( basicConfigs -> {
                    basicConfigs.authenticationEntryPoint( (request, response, authException) -> {
                        ObjectMapper mapper = new ObjectMapper();

                        ResponseBody responseBody = new ResponseBody();
                        responseBody.setCode(HttpStatus.UNAUTHORIZED.value());
                        responseBody.setStatus(HttpStatus.valueOf(response.getStatus()));
                        responseBody.setMensagem( "Não foi possível acessar o serviço." );
                        responseBody.setData(new ArrayList<>());
                        response.setStatus(response.getStatus());
                        response.setCharacterEncoding("UTF-8");

                        JSONObject json = new JSONObject(responseBody);
                        response.getWriter().write( json.toString() );
                   });
                })
                .sessionManagement( sess -> sess.sessionCreationPolicy( SessionCreationPolicy.STATELESS) )
                .addFilterBefore( this.usuarioFilterMiddleware, UsernamePasswordAuthenticationFilter.class)
                .cors( cors -> cors.configurationSource( this.habilitarCors()) );

        return security.build();
    }
}
