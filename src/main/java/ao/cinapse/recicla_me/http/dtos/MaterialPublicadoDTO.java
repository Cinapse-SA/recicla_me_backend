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
        entity.setIdMaterialReciclavel( MaterialReciclavelDTO.builder().build().cast(dto.getMaterialReciclavel()));

        MaterialPublicadoArquivoDTO parse = MaterialPublicadoArquivoDTO.builder().build();
        entity.setImages( parse.toListFromDtoList( dto.getImages()) );
        return entity;
    }

    @Override
    public MaterialPublicadoDTO parse(MaterialPublicado entity) {
        MaterialPublicadoDTO dto = MaterialPublicadoDTO.builder().build();
        BeanUtils.copyProperties(entity, dto);

        dto.setMaterialReciclavel(MaterialReciclavelDTO.builder().build().parse(entity.getIdMaterialReciclavel()));

        MaterialPublicadoArquivoDTO parse = MaterialPublicadoArquivoDTO.builder().build();
        dto.setImages(parse.toListFromEntityList(entity.getImages()));
        return dto;
    }

    @Override
    public MaterialPublicado cast() {
        MaterialPublicado entity = MaterialPublicado.builder().build();
        BeanUtils.copyProperties(this, entity);

        entity.setIdMaterialPublicado(this.getId());
        entity.setIdMaterialReciclavel( MaterialReciclavelDTO.builder().build().cast(this.getMaterialReciclavel()));

        MaterialPublicadoArquivoDTO parse = MaterialPublicadoArquivoDTO.builder().build();
        entity.setImages( parse.toListFromDtoList( this.getImages()) );
        return entity;
    }
}
