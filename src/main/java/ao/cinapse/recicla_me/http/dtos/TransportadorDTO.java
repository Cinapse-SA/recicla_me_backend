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
    private String numeroTransportador;
    private PessoaDTO pessoa;
    private TipoTransportadorDTO tipoTransportador;

    @Override
    public Transportador cast(TransportadorDTO dto) {
        Transportador entity = new Transportador();
        BeanUtils.copyProperties(dto, entity);
        if ( dto.getPessoa() != null )
            entity.setIdPessoa( PessoaDTO.builder().build().cast(dto.getPessoa()));
        if ( dto.getTipoTransportador() != null )
            entity.setIdTipoTransportador( TipoTransportadorDTO.builder().build().cast(dto.getTipoTransportador()));
        entity.setIdTransportador(dto.getId());
        return entity;
    }

    @Override
    public TransportadorDTO parse(Transportador entity) {
        TransportadorDTO dto = new TransportadorDTO();
        BeanUtils.copyProperties(entity, dto);
        if ( entity.getIdPessoa() != null )
            dto.setPessoa( PessoaDTO.builder().build().parse(entity.getIdPessoa()));
        if ( entity.getIdTipoTransportador() != null )
            dto.setTipoTransportador( TipoTransportadorDTO.builder().build().parse(entity.getIdTipoTransportador()));
        dto.setId(entity.getIdTransportador());
        return dto;
    }

    @Override
    public Transportador cast() {
        Transportador entity = new Transportador();
        BeanUtils.copyProperties(this, entity);
        if ( this.getPessoa() != null )
            entity.setIdPessoa( PessoaDTO.builder().build().cast(this.getPessoa()));
        if ( this.getTipoTransportador() != null )
            entity.setIdTipoTransportador( TipoTransportadorDTO.builder().build().cast(this.getTipoTransportador()));
        entity.setIdTransportador(this.getId());
        return entity;
    }
}
