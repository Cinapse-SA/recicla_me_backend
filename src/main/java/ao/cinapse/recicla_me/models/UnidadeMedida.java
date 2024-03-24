package ao.cinapse.recicla_me.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "unidade_medida")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UnidadeMedida implements Serializable
{
    @Id
    @GeneratedValue
    private UUID idUnidadeMedida;
    private String unidade;
    private String codigo;
}
