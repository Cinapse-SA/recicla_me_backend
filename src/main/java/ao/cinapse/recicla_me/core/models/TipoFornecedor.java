package ao.cinapse.recicla_me.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "tipo_fornecedor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoFornecedor implements Serializable {

    @Id
    @GeneratedValue
    private UUID idTipoFornecedor;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String denominacao;

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
