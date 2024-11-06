package ao.cinapse.recicla_me.core.kafka.producers;

import ao.cinapse.recicla_me.core.kafka.interfaces.IPagamentoServiceProducer;
import ao.cinapse.recicla_me.core.kafka.models.DataQueue;
import ao.cinapse.recicla_me.core.kafka.models.TransacaoDTO;
import ao.cinapse.recicla_me.core.models.Publicacao;
import ao.cinapse.recicla_me.core.security.UsuarioLogadoService;
import ao.cinapse.recicla_me.core.services.implementacao.PublicacaoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class PagamentoServiceProducer implements IPagamentoServiceProducer
{
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Value("${topicos.executar-pagamento}")
    private String TOPIC_EXECUTAR_PAGAMENTO;

    @Autowired
    private PublicacaoServiceImpl publicacaoService;


    @Override
    public void executar(UUID idPublicacao)
    {
        Optional<Publicacao> publicacao = this.publicacaoService.findById( idPublicacao );
        try {
            TransacaoDTO dto = this.transformToTransacaoDTO( publicacao.get() );

            dto.setIdPessoaOrigem( usuarioLogadoService.getUsuario().getIdPessoa().getIdPessoa().toString() );
            dto.setNomePessoaOrigem( usuarioLogadoService.getUsuario().getIdPessoa().getNome() );
            dto.setNifPessoaOrigem( usuarioLogadoService.getUsuario().getIdPessoa().getNif() );

            DataQueue<TransacaoDTO> dataQueue = new DataQueue<>();
            dataQueue.setData( dto );

            kafkaTemplate.send(TOPIC_EXECUTAR_PAGAMENTO, objectMapper.writeValueAsString(dataQueue));
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private TransacaoDTO transformToTransacaoDTO(Publicacao publicacao) {
        return TransacaoDTO
                .builder()
                .idPessoaDestino( publicacao.getIdFornecedor().getIdPessoa().getIdPessoa().toString() )
                .nomePessoaDestino( publicacao.getIdFornecedor().getIdPessoa().getNome() )
                .nifPessoaDestino( publicacao.getIdFornecedor().getIdPessoa().getNif() )
                .idPublicacao( publicacao.getIdPublicacao().toString() )
                .custoTotal( publicacao.getCustoTotal() )
                .build();
    }
}
