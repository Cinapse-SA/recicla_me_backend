package ao.cinapse.recicla_me.controllers.material;



import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.AgendamentoRecolhaDTO;
import ao.cinapse.recicla_me.http.dtos.PublicacaoDTO;
import ao.cinapse.recicla_me.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.models.Publicacao;
import ao.cinapse.recicla_me.services.implementacao.AgendamentoRecolhaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("agendamento_recolha")
@RestController
public class AgendamentoRecolhaController  extends BaseController<ResponseBody, AgendamentoRecolhaDTO, AgendamentoRecolha, UUID, AgendamentoRecolhaServiceImpl>
{
    @Override
    public ResponseEntity<ResponseBody> listar(Pageable page) {
        return this.ok("Lista de Agendamentos", AgendamentoRecolhaDTO.builder().build().toListFromEntityList(this.getService().findAll()));
    }

    @GetMapping("/findByPublicacaoId/{id}")
    public ResponseEntity<ResponseBody> findByPublicacaoId( @PathVariable("id") String publicacaoId)
    {
        List<AgendamentoRecolha> list = this.getService().findByPublicacaoId(Publicacao.builder().idPublicacao(UUID.fromString(publicacaoId)).build());
        return this.ok("Agendamentos em Publicação de Recolha", AgendamentoRecolhaDTO.builder().build().toListFromEntityList(list));
    }
}
