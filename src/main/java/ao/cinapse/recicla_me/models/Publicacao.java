package ao.cinapse.recicla_me.models;

import jakarta.persistence.*;
import jdk.jfr.Label;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@ToString
@Entity(name = "publicacao")
public class Publicacao implements Serializable
{
    @Id
    @GeneratedValue
    private UUID idPublicacao;

    private Double pesoTotal;
    private Double custo;

    private LocalDateTime horarioRecolha;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idFornecedor", name = "id_fornecedor", nullable = false)
    private Fornecedor idFornecedor;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idEstadoPublicacao", name = "id_estado_publicacao", nullable = false)
    private EstadoPublicacao idEstadoPublicacao;

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
