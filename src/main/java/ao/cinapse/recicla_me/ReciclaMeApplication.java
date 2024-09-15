package ao.cinapse.recicla_me;

import ao.cinapse.recicla_me.services.interfaces.ArquivoService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"ao.cinapse.recicla_me.services.implementacao"})
public class ReciclaMeApplication implements CommandLineRunner {
	@Resource
	private ArquivoService arquivoService;

	public static void main(String[] args) {
		SpringApplication.run(ReciclaMeApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void run(String... args) throws Exception {
		this.arquivoService.init();
	}
}
