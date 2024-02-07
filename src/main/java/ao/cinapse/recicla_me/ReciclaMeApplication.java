package ao.cinapse.recicla_me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = {"ao.cinapse.recicla_me.controllers.auth","ao.cinapse.recicla_me.controllers"})
public class ReciclaMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReciclaMeApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
