package ao.cinapse.recicla_me.core.configuracao;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Cinapse SA",
                        email = "dev@cinapse.ao",
                        url = "https://cinapse.ao"
                ),
                description = "Documentação Projecto Recicle-Me",
                title = "Recicle-me Specificacao API",
                version = "1.0",
                license = @License(name = "Licence", url = "https://cinapse.ao"),
                termsOfService = "Termos e Condições"
        )
        /*
        ,
        servers = {
            @Server(
                description = "Local Environment",
                url = "http://localhost:17043"
            ),
            @Server(
                description = "Dev Environment",
                url = "https://reciclame-api-dev.up.railway.app"
            )
        }
         */
)
/*
@SecurityScheme(
    name = "BearerAuth",
    description = "Jwt Auth description",
    scheme = "bearer",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    in = SecuritySchemeIn.HEADER
)
 */
public class SwaggerConfiguracao
{

    @Bean
    public GroupedOpenApi defineOpenApi() {
      return GroupedOpenApi.builder()
              .group("ao.cinapse")
              .pathsToMatch("/**")
              .packagesToScan("ao.cinapse.recicla_me.controllers")
              .build();
    }
}
