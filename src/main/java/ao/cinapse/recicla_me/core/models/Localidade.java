package ao.cinapse.recicla_me.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "localidade")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Localidade  {
    @Id
    @GeneratedValue
    private UUID idLocalidade;
    private String denominacao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idLocalidade", name = "id_parent", nullable = true)
    @JsonIgnore
    private Localidade idParent;

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
