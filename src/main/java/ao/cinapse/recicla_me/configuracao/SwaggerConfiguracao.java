package ao.cinapse.recicla_me.configuracao;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
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
