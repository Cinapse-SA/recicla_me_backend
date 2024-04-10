package ao.cinapse.recicla_me.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "fornecedor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor implements Serializable
{
    @Id
    @GeneratedValue
    private UUID idFornecedor;

    private String numeroFornecedor;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPessoa", name = "id_pessoa", nullable = false)
    private Pessoa idPessoa;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idTipoFornecedor", name = "id_tipo_fornecedor", nullable = false)
    private TipoFornecedor idTipoFornecedor;



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
