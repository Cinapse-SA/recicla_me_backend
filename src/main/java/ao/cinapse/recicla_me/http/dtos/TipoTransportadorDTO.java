package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.TipoTransportador;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TipoTransportadorDTO extends AbstractDTO<TipoTransportador, TipoTransportadorDTO>
{
    private UUID id;
    private String codigo;
    private String denominacao;
    private String descricao;

    @Override
    public TipoTransportador cast(TipoTransportadorDTO dto) {
        TipoTransportador entidade = new TipoTransportador();
        BeanUtils.copyProperties(dto, entidade);
        entidade.setIdTipoTransportador( dto.getId() );
        return entidade;
    }

    @Override
    public TipoTransportadorDTO parse(TipoTransportador entity) {
        TipoTransportadorDTO dto = new TipoTransportadorDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setId(entity.getIdTipoTransportador());
        return dto;
    }

    @Override
    public TipoTransportador cast() {
        TipoTransportador entidade = new TipoTransportador();
        BeanUtils.copyProperties(this, entidade);
        entidade.setIdTipoTransportador( this.getId() );
        return entidade;
    }
}
