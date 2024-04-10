package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.MaterialPublicado;
import ao.cinapse.recicla_me.models.MaterialPublicadoArquivo;
import ao.cinapse.recicla_me.models.MaterialReciclavel;
import ao.cinapse.recicla_me.models.Publicacao;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialPublicadoDTO extends AbstractDTO<MaterialPublicado, MaterialPublicadoDTO>
{
    private UUID id;
    private Double preco;
    private Double peso;
    private List<MaterialPublicadoArquivoDTO> images;
    private MaterialReciclavelDTO materialReciclavel;

    @Override
    public MaterialPublicado cast(MaterialPublicadoDTO dto) {
        MaterialPublicado entity = MaterialPublicado.builder().build();
        BeanUtils.copyProperties(dto, entity);
        entity.setIdMaterialPublicado(dto.getId());

        if ( dto.getMaterialReciclavel() != null )
            entity.setIdMaterialReciclavel( MaterialReciclavelDTO.builder().build().cast(dto.getMaterialReciclavel()));
        if (dto.getImages() != null )
            entity.setImages( MaterialPublicadoArquivoDTO.builder().build().toListFromDtoList( dto.getImages()) );
        return entity;
    }

    @Override
    public MaterialPublicadoDTO parse(MaterialPublicado entity) {
        MaterialPublicadoDTO dto = MaterialPublicadoDTO.builder().build();
        BeanUtils.copyProperties(entity, dto);
        if ( entity.getIdMaterialReciclavel() != null)
            dto.setMaterialReciclavel(MaterialReciclavelDTO.builder().build().parse(entity.getIdMaterialReciclavel()));
        if ( entity.getImages() != null )
            dto.setImages(MaterialPublicadoArquivoDTO.builder().build().toListFromEntityList(entity.getImages()));
        dto.setId(entity.getIdMaterialPublicado());
        return dto;
    }

    @Override
    public MaterialPublicado cast() {
        MaterialPublicado entity = MaterialPublicado.builder().build();
        BeanUtils.copyProperties(this, entity);

        entity.setIdMaterialPublicado(this.getId());
        if ( this.getMaterialReciclavel() != null)
            entity.setIdMaterialReciclavel( MaterialReciclavelDTO.builder().build().cast(this.getMaterialReciclavel()));
        if ( this.getImages() != null)
            entity.setImages( MaterialPublicadoArquivoDTO.builder().build().toListFromDtoList( this.getImages()) );
        return entity;
    }
}
