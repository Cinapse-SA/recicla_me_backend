package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.models.EstadoAgendamentoRecolha;
import ao.cinapse.recicla_me.models.Publicacao;
import ao.cinapse.recicla_me.models.Transportador;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AgendamentoRecolhaDTO extends AbstractDTO<AgendamentoRecolha, AgendamentoRecolhaDTO>
{
    private UUID id;
    private PublicacaoDTO publicacao;
    private EstadoAgendamentoRecolhaDTO estadoAgendamentoRecolha;
    private LocalDateTime horarioRecolha;
    private TransportadorDTO transportador;


    @Override
    public AgendamentoRecolha cast(AgendamentoRecolhaDTO dto) {
        AgendamentoRecolha entity = new AgendamentoRecolha();
        BeanUtils.copyProperties(dto, entity);

        entity.setIdPublicacao( PublicacaoDTO.builder().build().cast(dto.getPublicacao()));
        entity.setIdEstadoAgendamentoRecolha( EstadoAgendamentoRecolhaDTO.builder().build().cast(dto.getEstadoAgendamentoRecolha()));
        entity.setIdTransportador( TransportadorDTO.builder().build().cast(dto.getTransportador()) );
        entity.setIdAgendamentoRecolha( dto.getId());
        return entity;
    }

    @Override
    public AgendamentoRecolhaDTO parse(AgendamentoRecolha entity) {
        AgendamentoRecolhaDTO dto = new AgendamentoRecolhaDTO();
        BeanUtils.copyProperties(entity, dto);

        dto.setId( entity.getIdAgendamentoRecolha() );
        dto.setPublicacao( PublicacaoDTO.builder().build().parse(entity.getIdPublicacao()) );
        dto.setTransportador( TransportadorDTO.builder().build().parse(entity.getIdTransportador()));
        dto.setEstadoAgendamentoRecolha( EstadoAgendamentoRecolhaDTO.builder().build().parse(entity.getIdEstadoAgendamentoRecolha()));

        return dto;
    }

    @Override
    public AgendamentoRecolha cast() {
        AgendamentoRecolha entity = new AgendamentoRecolha();
        BeanUtils.copyProperties(this, entity);

        entity.setIdPublicacao( PublicacaoDTO.builder().build().cast(this.getPublicacao()));
        entity.setIdEstadoAgendamentoRecolha( EstadoAgendamentoRecolhaDTO.builder().build().cast(this.getEstadoAgendamentoRecolha()));
        entity.setIdTransportador( TransportadorDTO.builder().build().cast(this.getTransportador()) );
        entity.setIdAgendamentoRecolha( this.getId());
        return entity;
    }
}
