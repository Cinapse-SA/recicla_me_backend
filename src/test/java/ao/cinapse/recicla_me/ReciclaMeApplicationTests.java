package ao.cinapse.recicla_me;

import ao.cinapse.recicla_me.http.dtos.AgendamentoRecolhaDTO;
import ao.cinapse.recicla_me.services.implementacao.AgendamentoRecolhaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReciclaMeApplicationTests
{
	@Test
	void contextLoads() {
	}

	@Test
	void testarAgendamentoRecolha() {
		AgendamentoRecolhaDTO agendamentoRecolhaDTO = new AgendamentoRecolhaDTO();
	}
}
