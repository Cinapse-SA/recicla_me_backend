package ao.cinapse.recicla_me.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "agendamento_recolha")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoRecolha {
    @Id
    @GeneratedValue
    private UUID idAgendamentoRecolha;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPublicacao", name = "id_publicacao", nullable = false)
    @JsonIgnore
    private Publicacao idPublicacao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idEstadoAgendamentoRecolha", name = "id_estado_agendamento_recolha", nullable = false)
    private EstadoAgendamentoRecolha idEstadoAgendamentoRecolha;

    private LocalDateTime horarioRecolha;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idTransportador", name = "id_transportador", nullable = false)
    private Transportador idTransportador;


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
