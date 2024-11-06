package ao.cinapse.recicla_me.core.http.dtos;

import ao.cinapse.recicla_me.core.models.TipoMaterial;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class TipoMaterialDTO extends AbstractDTO<TipoMaterial, TipoMaterialDTO>
{
    private UUID id;
    private String denominacao;
    private String codigo;
    private String descricao;


    @Override
    public TipoMaterial cast(TipoMaterialDTO dto) {
        TipoMaterial tipoMaterial = TipoMaterial.builder().build();
        BeanUtils.copyProperties(dto, tipoMaterial);
        tipoMaterial.setIdTipoMaterial(dto.getId());
        return tipoMaterial;
    }

    @Override
    public TipoMaterialDTO parse(TipoMaterial entity) {
        TipoMaterialDTO tipoMaterialDTO = TipoMaterialDTO.builder().build();
        BeanUtils.copyProperties(entity, tipoMaterialDTO);
        tipoMaterialDTO.setId(entity.getIdTipoMaterial());
        return tipoMaterialDTO;
    }

    @Override
    public TipoMaterial cast() {
        TipoMaterial tipoMaterial = TipoMaterial.builder().build();
        BeanUtils.copyProperties(this, tipoMaterial);
        tipoMaterial.setIdTipoMaterial(this.getId());
        return tipoMaterial;
    }
}
