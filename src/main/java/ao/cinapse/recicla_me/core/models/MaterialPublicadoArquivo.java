package ao.cinapse.recicla_me.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "material_publicado_arquivos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MaterialPublicadoArquivo
{
    @Id
    @GeneratedValue
    private UUID idMaterialPublicadoArquivo;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idArquivo", name = "id_arquivo", nullable = false)
    private Arquivo idArquivo;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idMaterialPublicado", name = "id_material_publicado", nullable = false)
    private MaterialPublicado idMaterialPublicado;


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
