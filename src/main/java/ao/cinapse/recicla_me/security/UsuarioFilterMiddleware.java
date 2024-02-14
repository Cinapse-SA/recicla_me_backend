package ao.cinapse.recicla_me.security;

import ao.cinapse.recicla_me.models.Usuario;
import ao.cinapse.recicla_me.services.implementacao.UsuarioServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
public class UsuarioFilterMiddleware extends OncePerRequestFilter
{
    @Autowired
    private HandlerExceptionResolver handlerExceptionResolver;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsuarioServiceImpl usuarioService;

    private static Logger LOGGER = LoggerFactory.getLogger(UsuarioFilterMiddleware.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        final String authHeader = request.getHeader("Authorization");

        if ( request.getRequestURI().contains("/swagger") || request.getRequestURI().contains("api-docs") ) {
            LOGGER.error( String.format("Requested URI %s", request.getRequestURI()));
            filterChain.doFilter(request, response);
            return;
        }

        if ( authHeader != null  && authHeader.startsWith("Bearer") && !authHeader.isEmpty() )
        {
            try
            {
                final String jwt = authHeader.substring(7);
                System.err.println(jwt);
                final String username = jwtService.extractUsername(jwt.trim());
                System.err.println("Username -> "+username);

                if (username != null ) {
                    UserDetails user = this.usuarioService.loadUserByUsername( username );
                    System.err.println(user);
                    if ( jwtService.isTokenValid(jwt, user) )
                    {
                        System.err.println("Token valid -> "+user.getUsername());
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                user,
                                null,
                                user.getAuthorities()
                        );
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request) );
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                        System.err.println("Token valid -> "+user);
                    }
                }
            }
            catch (Exception ex) {
                System.err.println("Exceptionn -> "+ex.getMessage());
                this.handlerExceptionResolver.resolveException(request, response, null, ex);
            }
        }
        filterChain.doFilter(request, response);
    }

}
