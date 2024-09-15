package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Fornecedor;
import ao.cinapse.recicla_me.models.Publicacao;
import ao.cinapse.recicla_me.models.Recolha;
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
@Builder
@Getter
@Setter
@ToString
public class RecolhaDTO extends AbstractDTO<Recolha, RecolhaDTO>
{
    @Id
    @GeneratedValue
    private UUID id;
    private Double pesoTotal;
    private Double custoTotal;
    private LocalDateTime horarioRecolha;
    private String endereco;
    private String latitude;
    private String longitude;

    private PublicacaoDTO publicacao;
    private FornecedorDTO fornecedor;
    private TransportadorDTO transportador;


    @Override
    public Recolha cast(RecolhaDTO dto) {
        Recolha entity = new Recolha();
        BeanUtils.copyProperties(dto, entity);

        entity.setIdRecolha( dto.getId());
        entity.setIdPublicacao( PublicacaoDTO.builder().build().cast(dto.getPublicacao()));
        entity.setIdFornecedor( FornecedorDTO.builder().build().cast(dto.getFornecedor()) );
        entity.setIdTransportador( TransportadorDTO.builder().build().cast(dto.getTransportador()));
        return entity;
    }

    @Override
    public RecolhaDTO parse(Recolha entity) {
        RecolhaDTO dto = new RecolhaDTO();
        BeanUtils.copyProperties(entity, dto);

        dto.setId( entity.getIdRecolha() );
        dto.setPublicacao( PublicacaoDTO.builder().build().parse(entity.getIdPublicacao()));
        dto.setFornecedor( FornecedorDTO.builder().build().parse(entity.getIdFornecedor()));
        dto.setTransportador( TransportadorDTO.builder().build().parse(entity.getIdTransportador()));
        return dto;
    }

    @Override
    public Recolha cast() {
        Recolha entity = new Recolha();
        BeanUtils.copyProperties(this, entity);

        entity.setIdRecolha( this.getId());
        entity.setIdPublicacao( PublicacaoDTO.builder().build().cast(this.getPublicacao()));
        entity.setIdFornecedor( FornecedorDTO.builder().build().cast(this.getFornecedor()) );
        entity.setIdTransportador( TransportadorDTO.builder().build().cast(this.getTransportador()));
        return entity;
    }
}
