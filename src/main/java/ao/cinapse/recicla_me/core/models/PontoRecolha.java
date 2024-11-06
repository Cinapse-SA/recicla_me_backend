package ao.cinapse.recicla_me.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "ponto_recolha")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PontoRecolha {

    @Id
    @GeneratedValue
    private UUID idPontoRecolha;

    private String nome;
    private String telefone;
    private String email;

    private LocalDateTime horarioRecolha;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idLocalidade", name = "id_provincia")
    private Localidade provincia;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idLocalidade", name = "id_municipio")
    private Localidade municipio;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idLocalidade", name = "id_distrito")
    private Localidade distrito;

    private String endereco;

    private String latitude;
    private String longitude;

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
