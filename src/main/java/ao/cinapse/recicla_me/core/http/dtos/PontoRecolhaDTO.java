package ao.cinapse.recicla_me.core.http.dtos;

import ao.cinapse.recicla_me.core.models.PontoRecolha;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PontoRecolhaDTO extends AbstractDTO<PontoRecolha, PontoRecolhaDTO> {
    private UUID id;
    private String nome;
    private String telefone;
    private String email;
    private LocalidadeDTO provincia;
    private LocalidadeDTO municipio;
    private LocalidadeDTO distrito;
    private String endereco;
    private String latitude;
    private String longitude;

    @Override
    public PontoRecolha cast(PontoRecolhaDTO dto) {
        PontoRecolha entity = PontoRecolha.builder().build();
        BeanUtils.copyProperties(dto, entity);
        if ( dto.getProvincia() != null )
            entity.setProvincia( LocalidadeDTO.builder().build().cast(dto.getProvincia()));
        if ( dto.getMunicipio() != null)
            entity.setMunicipio( LocalidadeDTO.builder().build().cast(dto.getMunicipio()));
        if ( dto.getDistrito() != null )
            entity.setDistrito( LocalidadeDTO.builder().build().cast(dto.getDistrito()));
        entity.setIdPontoRecolha(dto.getId());
        return entity;
    }

    @Override
    public PontoRecolhaDTO parse(PontoRecolha entity) {
        PontoRecolhaDTO dto = PontoRecolhaDTO.builder().build();
        BeanUtils.copyProperties(entity, dto);
        if ( entity.getProvincia() != null )
            dto.setProvincia( LocalidadeDTO.builder().build().parse(entity.getProvincia()));
        if ( entity.getMunicipio() != null)
            dto.setMunicipio( LocalidadeDTO.builder().build().parse(entity.getMunicipio()));
        if ( entity.getDistrito() != null )
            dto.setDistrito( LocalidadeDTO.builder().build().parse(entity.getDistrito()));
        dto.setId( entity.getIdPontoRecolha() );
        return dto;
    }

    @Override
    public PontoRecolha cast()
    {
        PontoRecolha entity = PontoRecolha.builder().build();
        BeanUtils.copyProperties(this, entity);
        if ( this.getProvincia() != null )
            entity.setProvincia( LocalidadeDTO.builder().build().cast(this.getProvincia()));
        if ( this.getMunicipio() != null)
            entity.setMunicipio( LocalidadeDTO.builder().build().cast(this.getMunicipio()));
        if ( this.getDistrito() != null )
            entity.setDistrito( LocalidadeDTO.builder().build().cast(this.getDistrito()));
        entity.setIdPontoRecolha(this.getId());
        return entity;
    }
}
