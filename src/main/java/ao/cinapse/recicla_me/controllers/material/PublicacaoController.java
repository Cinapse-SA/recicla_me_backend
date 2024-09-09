package ao.cinapse.recicla_me.controllers.material;

import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.PublicacaoDTO;
import ao.cinapse.recicla_me.models.Publicacao;
import ao.cinapse.recicla_me.services.implementacao.PublicacaoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
