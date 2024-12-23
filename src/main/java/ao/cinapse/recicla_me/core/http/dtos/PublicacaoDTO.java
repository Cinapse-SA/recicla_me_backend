package ao.cinapse.recicla_me.core.http.dtos;

import ao.cinapse.recicla_me.core.models.Publicacao;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class PublicacaoDTO extends AbstractDTO<Publicacao, PublicacaoDTO>
{
    private UUID id;
    private Double pesoTotal;
    private Double custoTotal;
    private LocalDateTime horarioRecolha;
    private String latitude;
    private String longitude;
    private FornecedorDTO fornecedor;
    private EstadoPublicacaoDTO estado;
    private List<MaterialPublicadoDTO> items;
    private List<PontoRecolhaDTO> pontosRecolha;

    @Override
    public Publicacao cast(PublicacaoDTO dto)
    {
        Publicacao publicacao = Publicacao.builder().build();
        BeanUtils.copyProperties(dto, publicacao);

        publicacao.setIdPublicacao( dto.getId() );
        if ( dto.getFornecedor() != null )
            publicacao.setIdFornecedor(FornecedorDTO.builder().build().cast(dto.getFornecedor()));
        if ( dto.getEstado() != null )
            publicacao.setIdEstadoPublicacao(EstadoPublicacaoDTO.builder().build().cast( dto.getEstado()));
        if ( dto.getItems() != null )
            publicacao.setMaterialPublicadoList( MaterialPublicadoDTO.builder().build().toListFromDtoList(dto.getItems()));
        if (dto.getPontosRecolha() != null)
            publicacao.setPontoRecolhaList( PontoRecolhaDTO.builder().build().toListFromDtoList(dto.getPontosRecolha()));

        return publicacao;
    }

    @Override
    public PublicacaoDTO parse(Publicacao entity)
    {
        PublicacaoDTO dto = PublicacaoDTO.builder().build();
        BeanUtils.copyProperties(entity, dto);
        dto.setId( entity.getIdPublicacao() );

        if ( entity.getIdFornecedor() != null )
            dto.setFornecedor(FornecedorDTO.builder().build().parse( entity.getIdFornecedor() ));
        if ( entity.getIdEstadoPublicacao() != null )
            dto.setEstado(EstadoPublicacaoDTO.builder().build().parse(entity.getIdEstadoPublicacao()));
        if ( entity.getMaterialPublicadoList() != null && !entity.getMaterialPublicadoList().isEmpty())
            dto.setItems( MaterialPublicadoDTO.builder().build().toListFromEntityList(entity.getMaterialPublicadoList()));
        if ( entity.getPontoRecolhaList() != null && !entity.getPontoRecolhaList().isEmpty())
            dto.setPontosRecolha(PontoRecolhaDTO.builder().build().toListFromEntityList(entity.getPontoRecolhaList()));

        return dto;
    }

    @Override
    public Publicacao cast() {
        Publicacao publicacao = Publicacao.builder().build();
        BeanUtils.copyProperties(this, publicacao);
        publicacao.setIdPublicacao( this.getId() );

        publicacao.setIdFornecedor(FornecedorDTO.builder().build().cast(this.getFornecedor()));
        publicacao.setIdEstadoPublicacao(EstadoPublicacaoDTO.builder().build().cast(this.getEstado()));
        publicacao.setMaterialPublicadoList( MaterialPublicadoDTO.builder().build().toListFromDtoList(this.getItems()));
        publicacao.setPontoRecolhaList( PontoRecolhaDTO.builder().build().toListFromDtoList(this.getPontosRecolha()));

        return publicacao;
    }
}
