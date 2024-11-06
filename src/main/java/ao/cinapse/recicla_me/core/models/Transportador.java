package ao.cinapse.recicla_me.core.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "transportador")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transportador
{
    @Id
    @GeneratedValue
    private UUID idTransportador;

    private String numeroTransportador;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPessoa", name = "id_pessoa", nullable = false)
    private Pessoa idPessoa;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idTipoTransportador", name = "id_tipo_transportador", nullable = false)
    private TipoTransportador idTipoTransportador;

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
