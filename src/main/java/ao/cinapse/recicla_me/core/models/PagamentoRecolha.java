package ao.cinapse.recicla_me.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "pagamento_recolha")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoRecolha
{
    @Id
    @GeneratedValue
    private UUID idPagamentoRecolha;
    private Double custoTotal;

    private String idTipoPagamento;
    private String descricaoTipoPagamento;
    private LocalDateTime horarioPagamento;

    private String idTransacao;
    private String descricaoTransacao;
    private String idEstadoTransacao;
    private String estadoTransacao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPublicacao", name = "id_publicacao", nullable = false)
    private Publicacao idPublicacao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idAgendamentoRecolha", name = "id_agendamento_recolha", nullable = true)
    private AgendamentoRecolha idAgendamentoRecolha;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private LocalDateTime deletedAt;

    @PrePersist
    public void init() {
        if ( this.createdAt == null )
            this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
