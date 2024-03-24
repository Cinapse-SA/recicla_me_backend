package ao.cinapse.recicla_me.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@ToString
@Entity(name = "material_publicado")
public class MaterialPublicado implements Serializable {

    @Id
    @GeneratedValue
    private UUID idMaterialPublicado;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = true)
    private String image;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idMaterialReciclavel", name = "id_material_reciclavel", nullable = false)
    private MaterialReciclavel idMaterialReciclavel;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPublicacao", name = "id_publicacao", nullable = false)
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
