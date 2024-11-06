package ao.cinapse.recicla_me.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "categoria_material")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoMaterial {

    @Id
    @GeneratedValue
    private UUID idTipoMaterial;

    @Column(nullable = false)
    private String denominacao;

    @Column(nullable = false)
    private String codigo;

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
