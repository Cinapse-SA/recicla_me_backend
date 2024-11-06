package ao.cinapse.recicla_me.core.http.dtos;

import ao.cinapse.recicla_me.core.models.TipoFornecedor;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoFornecedorDTO extends AbstractDTO<TipoFornecedor, TipoFornecedorDTO>
{
    private UUID id;
    private String codigo;
    private String denominacao;
    private String descricao;

    @Override
    public TipoFornecedor cast(TipoFornecedorDTO dto) {
        TipoFornecedor entity = new TipoFornecedor();
        BeanUtils.copyProperties(dto, entity);
        entity.setIdTipoFornecedor( dto.getId() );
        return entity;
    }

    @Override
    public TipoFornecedorDTO parse(TipoFornecedor entity) {
        TipoFornecedorDTO dto = new TipoFornecedorDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setId( entity.getIdTipoFornecedor() );
        return dto;
    }

    @Override
    public TipoFornecedor cast() {
        TipoFornecedor entity = new TipoFornecedor();
        BeanUtils.copyProperties(this, entity);
        entity.setIdTipoFornecedor( this.getId() );
        return entity;
    }
}
