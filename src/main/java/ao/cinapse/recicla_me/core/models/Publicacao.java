package ao.cinapse.recicla_me.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@ToString
@Entity(name = "publicacao")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publicacao implements Serializable
{
    @Id
    @GeneratedValue
    private UUID idPublicacao;

    private Double pesoTotal;
    private Double custoTotal;
    private LocalDateTime horarioRecolha;
    private String endereco;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idFornecedor", name = "id_fornecedor", nullable = false)
    private Fornecedor idFornecedor;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idEstadoPublicacao", name = "id_estado_publicacao", nullable = false)
    private EstadoPublicacao idEstadoPublicacao;

    @OneToMany(mappedBy = "idPublicacao")
    private List<MaterialPublicado> materialPublicadoList;

    @OneToMany(mappedBy = "idPublicacao")
    private List<PontoRecolha> pontoRecolhaList;

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
