package ao.cinapse.recicla_me.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "tipo_transportador")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoTransportador
{
    @Id
    @GeneratedValue
    private UUID idTipoTransportador;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String denominacao;

    private String descricao;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @PrePersist
    public void init() {
        if ( this.createdAt == null )
            this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}

