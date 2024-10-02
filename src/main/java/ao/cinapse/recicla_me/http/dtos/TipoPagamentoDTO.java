package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Localidade;
import ao.cinapse.recicla_me.models.TipoPagamento;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@ToString
@Component
public class TipoPagamentoDTO  extends AbstractDTO<TipoPagamento, TipoPagamentoDTO>
{
    private UUID id;
    private String denominacao;
    private String descricao;
    private String codigo;

    @Override
    public TipoPagamento cast(TipoPagamentoDTO dto) {
        TipoPagamento entity = new TipoPagamento();
        BeanUtils.copyProperties(dto, entity);
        entity.setIdTipoPagamento( dto.getId() );
        return entity;
    }

    @Override
    public TipoPagamentoDTO parse(TipoPagamento entity) {
        TipoPagamentoDTO dto = new TipoPagamentoDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setId(entity.getIdTipoPagamento());
        return dto;
    }

    @Override
    public TipoPagamento cast() {
        TipoPagamento entity = new TipoPagamento();
        BeanUtils.copyProperties(this, entity);
        entity.setIdTipoPagamento( this.getId() );
        return entity;
    }
}
