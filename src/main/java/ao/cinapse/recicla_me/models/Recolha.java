package ao.cinapse.recicla_me.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "recolha")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recolha {
    @Id
    @GeneratedValue
    private UUID idRecolha;

    private Double pesoTotal;
    private Double custoTotal;
    private LocalDateTime horarioRecolha;
    private String endereco;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPublicacao", name = "id_publicacao", nullable = false)
    @JsonIgnore
    private Publicacao idPublicacao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idFornecedor", name = "id_fornecedor", nullable = false)
    private Fornecedor idFornecedor;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idTransportador", name = "id_transportador", nullable = false)
    private Transportador idTransportador;



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
