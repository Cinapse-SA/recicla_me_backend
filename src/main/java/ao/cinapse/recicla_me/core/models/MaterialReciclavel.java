package ao.cinapse.recicla_me.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "material_reciclavel")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaterialReciclavel implements Serializable {
    @Id
    @GeneratedValue
    private UUID idMaterialReciclavel;

    @Column(nullable = false)
    private String denominacao;
    private String descricao;
    @Column(nullable = false)
    private Double preco;
    @Column(nullable = false)
    private Double peso;
    private String image;
    @Column(nullable = false)
    private String codigo;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idTipoMaterial", name = "id_tipo_material", nullable = false)
    private TipoMaterial idTipoMaterial;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idUnidadeMedida", name = "id_unidade_medida", nullable = false)
    private UnidadeMedida idUnidadeMedida;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Column(nullable = true)
    private LocalDateTime deletedAt;


    @PrePersist
    public void init()
    {
        if ( this.createdAt == null )
            this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
