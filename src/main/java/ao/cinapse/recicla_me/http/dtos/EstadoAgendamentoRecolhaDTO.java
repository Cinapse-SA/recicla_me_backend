package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.EstadoAgendamentoRecolha;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EstadoAgendamentoRecolhaDTO extends AbstractDTO<EstadoAgendamentoRecolha, EstadoAgendamentoRecolhaDTO>
{
    private UUID id;
    private String codigo;
    private String denominacao;
    private String descricao;

    @Override
    public EstadoAgendamentoRecolha cast(EstadoAgendamentoRecolhaDTO dto) {
        EstadoAgendamentoRecolha entity = new EstadoAgendamentoRecolha();
        BeanUtils.copyProperties(dto, entity);
        entity.setIdEstadoAgendamentoRecolha( dto.getId() );
        return entity;
    }

    @Override
    public EstadoAgendamentoRecolhaDTO parse(EstadoAgendamentoRecolha entity) {
        EstadoAgendamentoRecolhaDTO dto = new EstadoAgendamentoRecolhaDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setId( entity.getIdEstadoAgendamentoRecolha() );
        return dto;
    }

    @Override
    public EstadoAgendamentoRecolha cast() {
        EstadoAgendamentoRecolha entity = new EstadoAgendamentoRecolha();
        BeanUtils.copyProperties(this, entity);
        entity.setIdEstadoAgendamentoRecolha( this.getId());
        return entity;
    }
}
