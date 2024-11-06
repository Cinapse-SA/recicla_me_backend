package ao.cinapse.recicla_me.core.controllers.material;

import ao.cinapse.recicla_me.core.controllers.base.BaseController;
import ao.cinapse.recicla_me.core.http.ResponseBody;
import ao.cinapse.recicla_me.core.http.dtos.PublicacaoDTO;
import ao.cinapse.recicla_me.core.http.requests.PagamentoRecolhaRequest;
import ao.cinapse.recicla_me.core.kafka.producers.PagamentoServiceProducer;
import ao.cinapse.recicla_me.core.models.Publicacao;
import ao.cinapse.recicla_me.core.services.implementacao.PublicacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/publicacao")
public class PublicacaoController extends BaseController<ResponseBody, PublicacaoDTO, Publicacao, UUID, PublicacaoServiceImpl>
{
    @Override
    public ResponseEntity<ResponseBody> listar(Pageable page) {
        return this.ok("Lista de Publicações", PublicacaoDTO.builder().build().toListFromEntityList(this.getService().findAll()));
    }
}
