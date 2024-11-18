package ao.cinapse.recicla_me.core.controllers.material;

import ao.cinapse.recicla_me.core.controllers.base.BaseController;
import ao.cinapse.recicla_me.core.http.ResponseBody;
import ao.cinapse.recicla_me.core.http.dtos.PublicacaoDTO;
import ao.cinapse.recicla_me.core.http.requests.CompletarRecolhaRequest;
import ao.cinapse.recicla_me.core.http.requests.PagamentoRecolhaRequest;
import ao.cinapse.recicla_me.core.kafka.producers.PagamentoServiceProducer;
import ao.cinapse.recicla_me.core.models.Publicacao;
import ao.cinapse.recicla_me.core.services.implementacao.PagamentoRecolhaServiceImpl;
import ao.cinapse.recicla_me.core.services.implementacao.PublicacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/publicacao")
public class PublicacaoController extends BaseController<ResponseBody, PublicacaoDTO, Publicacao, UUID, PublicacaoServiceImpl>
{
    @Autowired
    private PagamentoRecolhaServiceImpl pagamentoRecolhaService;

    @Override
    public ResponseEntity<ResponseBody> listar(@PageableDefault(size = 10, page = 0) Pageable page) {
        try
        {
            Page<Publicacao> paged = this.getService().findAllPaginado(page);
            List<Publicacao> list = paged.getContent();
            return ok(
                "Lista de Publicações",
                PublicacaoDTO.builder().build().toListFromEntityList(list)
            );
        }
        catch (Exception e) {
            return badRequest(e.getMessage(), new ArrayList<>());
        }
    }

    @GetMapping("/pendente")
    public ResponseEntity<ResponseBody> findAllPendentes(@PageableDefault(size = 10, page = 0) Pageable page)
    {
        try
        {
            Page<Publicacao> paged = this.getService().findAllPendentes(page);
            List<Publicacao> list = paged.getContent();
            return ok(
                "Lista de Publicações Pendentes",
                PublicacaoDTO.builder().build().toListFromEntityList(list)
            );
        }
        catch (Exception e) {
            return badRequest(e.getMessage(), new ArrayList<>());
        }
    }

    @GetMapping("/pronta-recolher")
    public ResponseEntity<ResponseBody> prontaRecolher(@PageableDefault(size = 10, page = 0) Pageable page)
    {
        try
        {
            Page<Publicacao> paged = this.getService().findAllProntaRecolher(page);
            List<Publicacao> list = paged.getContent();
            return ok(
            "Lista de Publicações",
                PublicacaoDTO.builder().build().toListFromEntityList(list)
            );
        }
        catch (Exception e) {
            return badRequest(e.getMessage(), new ArrayList<>());
        }
    }

    @PutMapping("/completar-recolha")
    public ResponseEntity<ResponseBody> completarRecolha(@RequestBody CompletarRecolhaRequest request) {
        try
        {
            Publicacao publicacao = this.pagamentoRecolhaService.completarRecolha(request);
            return ok(
                "Parabéns, mais uma recolha efectuada",
                PublicacaoDTO.builder().build().parse(publicacao)
            );
        }
        catch (Exception e) {
            return badRequest(e.getMessage(), new ArrayList<>());
        }
    }
}
