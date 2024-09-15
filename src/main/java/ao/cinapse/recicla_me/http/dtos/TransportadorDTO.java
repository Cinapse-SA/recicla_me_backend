package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Pessoa;
import ao.cinapse.recicla_me.models.TipoTransportador;
import ao.cinapse.recicla_me.models.Transportador;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransportadorDTO extends AbstractDTO<Transportador, TransportadorDTO>
{
    private UUID id;
    private String numeroFornecedor;
    private PessoaDTO pessoa;
    private TipoTransportadorDTO tipoTransportador;

    @Override
    public Transportador cast(TransportadorDTO dto) {
        Transportador entity = new Transportador();
        BeanUtils.copyProperties(dto, entity);
        entity.setIdPessoa( PessoaDTO.builder().build().cast(dto.getPessoa()));
        entity.setIdTipoTransportador( TipoTransportadorDTO.builder().build().cast(dto.getTipoTransportador()));
        entity.setIdTransportador(dto.getId());
        return entity;
    }

    @Override
    public TransportadorDTO parse(Transportador entity) {
        TransportadorDTO dto = new TransportadorDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setPessoa( PessoaDTO.builder().build().parse(entity.getIdPessoa()));
        dto.setTipoTransportador( TipoTransportadorDTO.builder().build().parse(entity.getIdTipoTransportador()));
        dto.setId(entity.getIdTransportador());
        return dto;
    }

    @Override
    public Transportador cast() {
        Transportador entity = new Transportador();
        BeanUtils.copyProperties(this, entity);
        entity.setIdPessoa( PessoaDTO.builder().build().cast(this.getPessoa()));
        entity.setIdTipoTransportador( TipoTransportadorDTO.builder().build().cast(this.getTipoTransportador()));
        entity.setIdTransportador(this.getId());
        return entity;
    }
}
