package ao.cinapse.recicla_me;

import ao.cinapse.recicla_me.security.JwtService;
import ao.cinapse.recicla_me.services.implementacao.PessoaServiceImpl;
import ao.cinapse.recicla_me.services.implementacao.UsuarioServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ReciclaMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReciclaMeApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
