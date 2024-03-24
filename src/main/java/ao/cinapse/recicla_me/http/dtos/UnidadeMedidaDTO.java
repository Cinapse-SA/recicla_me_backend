package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.UnidadeMedida;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeMedidaDTO extends AbstractDTO<UnidadeMedida, UnidadeMedidaDTO> {

    private UUID id;
    private String unidade;
    private String codigo;

    @Override
    public UnidadeMedida cast(UnidadeMedidaDTO dto) {
        UnidadeMedida unidadeMedida = new UnidadeMedida();
        BeanUtils.copyProperties(dto, unidadeMedida);
        unidadeMedida.setIdUnidadeMedida( dto.getId());
        return  unidadeMedida;
    }

    @Override
    public UnidadeMedidaDTO parse(UnidadeMedida entity) {
        UnidadeMedidaDTO dto = new UnidadeMedidaDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setId( entity.getIdUnidadeMedida() );
        return  dto;
    }

    @Override
    public UnidadeMedida cast() {
        UnidadeMedida unidadeMedida = new UnidadeMedida();
        BeanUtils.copyProperties(this, unidadeMedida);
        unidadeMedida.setIdUnidadeMedida( this.getId());
        return  unidadeMedida;
    }
}
