package ao.cinapse.recicla_me.core;

import ao.cinapse.recicla_me.core.services.interfaces.ArquivoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"ao.cinapse.recicla_me.core.services.implementacao"})
public class ReciclaMeCoreApplication implements CommandLineRunner {
	@Resource
	private ArquivoService arquivoService;

	public static void main(String[] args) {
		SpringApplication.run(ReciclaMeCoreApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void run(String... args) throws Exception {
		this.arquivoService.init();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		return mapper;
	}
}
