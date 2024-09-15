package ao.cinapse.recicla_me.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "estado_agendamento_recolha")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoAgendamentoRecolha
{
    @Id
    @GeneratedValue
    private UUID idEstadoAgendamentoRecolha;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String denominacao;

    @Column(nullable = true)
    private String descricao;

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
