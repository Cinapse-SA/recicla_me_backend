package ao.cinapse.recicla_me.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@ToString
@Entity(name = "material_publicado")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialPublicado implements Serializable {

    @Id
    @GeneratedValue
    private UUID idMaterialPublicado;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Double peso;

    @OneToMany(mappedBy = "idMaterialPublicado")
    private List<MaterialPublicadoArquivo> images;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idMaterialReciclavel", name = "id_material_reciclavel", nullable = false)
    private MaterialReciclavel idMaterialReciclavel;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPublicacao", name = "id_publicacao", nullable = false)
    @JsonIgnore
    private Publicacao idPublicacao;

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
