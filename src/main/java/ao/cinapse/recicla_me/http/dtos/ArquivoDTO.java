package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Arquivo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoDTO extends AbstractDTO<Arquivo, ArquivoDTO>
{
    private UUID id;
    private String path;
    private String fileExtension;
    private String file;
    private String size;
    private String fileName;
    private String folder;

    @Override
    public Arquivo cast(ArquivoDTO dto) {
        Arquivo entity = Arquivo.builder().build();
        BeanUtils.copyProperties(dto, entity);
        entity.setIdArquivo(dto.getId());
        return entity;
    }

    @Override
    public ArquivoDTO parse(Arquivo entity) {
        ArquivoDTO dto = ArquivoDTO.builder().build();
        BeanUtils.copyProperties(entity, dto);
        dto.setId(entity.getIdArquivo());
        return dto;
    }

    @Override
    public Arquivo cast() {
        Arquivo entity = Arquivo.builder().build();
        BeanUtils.copyProperties(this, entity);
        entity.setIdArquivo(this.getId());
        return entity;
    }
}
