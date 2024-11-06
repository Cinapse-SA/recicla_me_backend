package ao.cinapse.recicla_me.core.controllers.pagamento;

import ao.cinapse.recicla_me.core.controllers.base.BaseController;
import ao.cinapse.recicla_me.core.http.ResponseBody;
import ao.cinapse.recicla_me.core.http.dtos.ArquivoDTO;
import ao.cinapse.recicla_me.core.http.dtos.PagamentoRecolhaDTO;
import ao.cinapse.recicla_me.core.http.requests.PagamentoRecolhaRequest;
import ao.cinapse.recicla_me.core.kafka.producers.PagamentoServiceProducer;
import ao.cinapse.recicla_me.core.models.Arquivo;
import ao.cinapse.recicla_me.core.models.PagamentoRecolha;
import ao.cinapse.recicla_me.core.models.Publicacao;
import ao.cinapse.recicla_me.core.services.implementacao.ArquivoServiceImpl;
import ao.cinapse.recicla_me.core.services.implementacao.PagamentoRecolhaServiceImpl;
import ao.cinapse.recicla_me.core.services.implementacao.PublicacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pagamento")
public class PagamentoRecolhaController extends BaseController<ResponseBody, PagamentoRecolhaDTO, PagamentoRecolha, UUID, PagamentoRecolhaServiceImpl>
{
    @Autowired
    private PagamentoServiceProducer pagamentoServiceProducer;


    @PostMapping("/recolha")
    public ResponseEntity<ResponseBody> pagar(@RequestBody PagamentoRecolhaRequest pagamento) {
        try {
            UUID id = UUID.fromString(pagamento.idPublicacao());
            this.pagamentoServiceProducer.executar( id );
            return this.loading("Pagamento em processamento...", new ArrayList<>());
        }
        catch (Exception e) {
            return this.badRequest("Não foi possível para a recolha: "+e.getMessage(), new ArrayList<>());
        }
    }
}
