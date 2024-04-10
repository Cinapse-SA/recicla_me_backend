package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Localidade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalidadeDTO extends AbstractDTO<Localidade, LocalidadeDTO>
{
    private UUID id;
    private String denominacao;
    @JsonIgnore
    private Localidade idParent;


    @Override
    public Localidade cast(LocalidadeDTO dto) {
        Localidade entity = Localidade.builder().build();
        BeanUtils.copyProperties(dto, entity);
        entity.setIdLocalidade(dto.getId());
        return entity;
    }

    @Override
    public LocalidadeDTO parse(Localidade entity) {
        LocalidadeDTO dto = LocalidadeDTO.builder().build();
        BeanUtils.copyProperties(entity, dto);
        dto.setId(entity.getIdLocalidade());
        return dto;
    }

    @Override
    public Localidade cast() {
        Localidade entity = Localidade.builder().build();
        BeanUtils.copyProperties(this, entity);
        entity.setIdLocalidade(this.getId());
        return entity;
    }
}
