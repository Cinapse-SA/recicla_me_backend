package ao.cinapse.recicla_me.core.http.dtos;

import ao.cinapse.recicla_me.core.models.MaterialPublicadoArquivo;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialPublicadoArquivoDTO extends AbstractDTO<MaterialPublicadoArquivo, MaterialPublicadoArquivoDTO>
{
    private UUID id;
    private ArquivoDTO arquivo;

    @Override
    public MaterialPublicadoArquivo cast(MaterialPublicadoArquivoDTO dto) {
        MaterialPublicadoArquivo entity = MaterialPublicadoArquivo.builder().build();
        if ( dto.getArquivo() != null )
            entity.setIdArquivo( ArquivoDTO.builder().build().cast(dto.getArquivo()) );
        entity.setIdMaterialPublicadoArquivo(dto.getId());
        return entity;
    }

    @Override
    public MaterialPublicadoArquivoDTO parse(MaterialPublicadoArquivo entity) {
        MaterialPublicadoArquivoDTO dto = MaterialPublicadoArquivoDTO.builder().build();
        if ( entity.getIdArquivo() != null)
            dto.setArquivo(ArquivoDTO.builder().build().parse(entity.getIdArquivo()));
        dto.setId(entity.getIdMaterialPublicadoArquivo());
        return dto;
    }

    @Override
    public MaterialPublicadoArquivo cast() {
        MaterialPublicadoArquivo entity = MaterialPublicadoArquivo.builder().build();
        if ( this.getArquivo() != null)
            entity.setIdArquivo( ArquivoDTO.builder().build().cast(this.getArquivo()) );
        entity.setIdMaterialPublicadoArquivo(this.getId());
        return entity;
    }
}
