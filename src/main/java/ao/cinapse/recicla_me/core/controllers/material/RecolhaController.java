package ao.cinapse.recicla_me.core.controllers.material;

import ao.cinapse.recicla_me.core.controllers.base.BaseController;
import ao.cinapse.recicla_me.core.http.ResponseBody;
import ao.cinapse.recicla_me.core.http.dtos.AgendamentoRecolhaDTO;
import ao.cinapse.recicla_me.core.http.dtos.RecolhaDTO;
import ao.cinapse.recicla_me.core.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.core.models.Recolha;
import ao.cinapse.recicla_me.core.services.implementacao.AgendamentoRecolhaServiceImpl;
import ao.cinapse.recicla_me.core.services.implementacao.RecolhaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("recolha")
public class RecolhaController extends BaseController<ResponseBody, RecolhaDTO, UUID, Recolha, RecolhaServiceImpl>
{
    @Autowired
    private AgendamentoRecolhaServiceImpl agendamentoRecolhaService;

    @Override
    public ResponseEntity<ResponseBody> listar(Pageable page) {
        return super.listar(page);
    }

    @PostMapping("/salvarUsandoAgendamento")
    public ResponseEntity<ResponseBody> salvarUsandoAgendamento(@RequestBody AgendamentoRecolhaDTO agendamentoRecolhaDTO)
    {
        try {
            Optional<AgendamentoRecolha> agendamentoRecolha = this.agendamentoRecolhaService.findById(agendamentoRecolhaDTO.getId());
            if ( agendamentoRecolha.isPresent() ) {
                Recolha recolha = this.getService().salvarUsandoAgendamento(agendamentoRecolha.get());
                return this.ok("Recolha salva com sucesso.",  RecolhaDTO.builder().build().parse( recolha ));
            }
            return this.badRequest("Não foi possível salvar a Recolha.", new ArrayList<>());
        }
        catch (Exception ex) {
            return this.badRequest("Não foi possível salvar a Recolha.", new ArrayList<>());
        }
    }
}
