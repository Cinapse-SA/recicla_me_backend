package ao.cinapse.recicla_me.models;

import jakarta.persistence.*;
import lombok.*;

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

    private String reference;
    private String externalReferenceId;

    private LocalDateTime horarioConfirmacaoPagamento;
    private LocalDateTime horarioValidadePagamento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idTipoPagamento", name = "id_tipo_pagamento", nullable = false)
    private TipoPagamento idTipoPagamento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idAgendamentoRecolha", name = "id_agendamento_recolha", nullable = false)
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
