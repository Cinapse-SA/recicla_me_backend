package ao.cinapse.recicla_me.controllers.material;



import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.AgendamentoRecolhaDTO;
import ao.cinapse.recicla_me.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.services.implementacao.AgendamentoRecolhaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("agendamento_recolha")
@RestController
public class AgendamentoRecolhaController  extends BaseController<ResponseBody, AgendamentoRecolhaDTO, AgendamentoRecolha, UUID, AgendamentoRecolhaServiceImpl> {
}
