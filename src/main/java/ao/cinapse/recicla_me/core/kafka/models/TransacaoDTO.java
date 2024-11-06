package ao.cinapse.recicla_me.core.kafka.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransacaoDTO
{
    private String idPessoaDestino;
    private String nifPessoaDestino;
    private String nomePessoaDestino;

    private String idPessoaOrigem;
    private String nifPessoaOrigem;
    private String nomePessoaOrigem;

    private String idPublicacao;
    private Double custoTotal;

    private String idTipoPagamento;
    private String descricaoTipoPagamento;
    private LocalDateTime horarioPagamento;

    private String idTransacao;
    private String descricaoTransacao;

    private String idEstadoTransacao;
    private String estadoTransacao;
}
