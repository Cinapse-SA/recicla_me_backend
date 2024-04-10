package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.MaterialReciclavel;
import ao.cinapse.recicla_me.models.TipoMaterial;
import ao.cinapse.recicla_me.models.UnidadeMedida;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MaterialReciclavelDTO extends AbstractDTO<MaterialReciclavel, MaterialReciclavelDTO>
{
    private UUID id;
    private String denominacao;
    private String descricao;
    private Double preco;
    private Double peso;
    private String image;
    private String codigo;
    private TipoMaterialDTO tipoMaterial;
    private UnidadeMedidaDTO unidadeMedida;


    @Override
    public MaterialReciclavel cast(MaterialReciclavelDTO dto) {
        MaterialReciclavel materialReciclavel = MaterialReciclavel.builder().build();
        BeanUtils.copyProperties(dto, materialReciclavel);

        materialReciclavel.setIdMaterialReciclavel(dto.getId());
        if ( dto.getTipoMaterial() != null)
            materialReciclavel.setIdTipoMaterial( new TipoMaterialDTO().cast( dto.getTipoMaterial()) );
        if (dto.getUnidadeMedida() != null)
            materialReciclavel.setIdUnidadeMedida(new UnidadeMedidaDTO().cast(dto.getUnidadeMedida()) );
        return materialReciclavel;
    }

    @Override
    public MaterialReciclavelDTO parse(MaterialReciclavel entity) {
        MaterialReciclavelDTO materialReciclavelDTO = MaterialReciclavelDTO.builder().build();
        BeanUtils.copyProperties(entity, materialReciclavelDTO);

        materialReciclavelDTO.setId(entity.getIdMaterialReciclavel());
        if ( entity.getIdTipoMaterial() != null)
            materialReciclavelDTO.setTipoMaterial((new TipoMaterialDTO().parse(entity.getIdTipoMaterial()) ));
        if ( entity.getIdUnidadeMedida() != null )
            materialReciclavelDTO.setUnidadeMedida( new UnidadeMedidaDTO().parse(entity.getIdUnidadeMedida()) );
        return materialReciclavelDTO;
    }

    @Override
    public MaterialReciclavel cast() {
        MaterialReciclavel materialReciclavel = MaterialReciclavel.builder().build();
        BeanUtils.copyProperties(this, materialReciclavel);

        materialReciclavel.setIdMaterialReciclavel(this.getId());
        if ( this.getTipoMaterial() != null)
            materialReciclavel.setIdTipoMaterial( new TipoMaterialDTO().cast( this.getTipoMaterial()) );
        if ( this.getUnidadeMedida() != null)
            materialReciclavel.setIdUnidadeMedida(new UnidadeMedidaDTO().cast(this.getUnidadeMedida()) );
        return materialReciclavel;
    }
}
