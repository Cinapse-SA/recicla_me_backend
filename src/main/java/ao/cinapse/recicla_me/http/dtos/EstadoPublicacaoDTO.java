package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.EstadoPublicacao;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EstadoPublicacaoDTO extends AbstractDTO<EstadoPublicacao, EstadoPublicacaoDTO> {

    private UUID id;
    private String denominacao;
    private String codigo;


    @Override
    public EstadoPublicacao cast(EstadoPublicacaoDTO dto) {
        EstadoPublicacao estado = EstadoPublicacao.builder().build();
        BeanUtils.copyProperties(dto, estado);
        estado.setIdEstadoPublicacao(dto.getId());
        return estado;
    }

    @Override
    public EstadoPublicacaoDTO parse(EstadoPublicacao entity) {
        EstadoPublicacaoDTO dto = EstadoPublicacaoDTO.builder().build();
        BeanUtils.copyProperties(entity, dto);
        dto.setId(entity.getIdEstadoPublicacao());
        return dto;
    }

    @Override
    public EstadoPublicacao cast() {
        EstadoPublicacao estado = EstadoPublicacao.builder().build();
        BeanUtils.copyProperties(this, estado);
        estado.setIdEstadoPublicacao(this.getId());
        return estado;
    }
}
