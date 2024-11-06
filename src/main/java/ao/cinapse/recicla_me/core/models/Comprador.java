package ao.cinapse.recicla_me.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "comprador")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comprador {
    @Id
    @GeneratedValue
    private UUID idComprador;
    private String numeroComprador;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPessoa", name = "id_pessoa", nullable = false)
    private Pessoa idPessoa;

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
