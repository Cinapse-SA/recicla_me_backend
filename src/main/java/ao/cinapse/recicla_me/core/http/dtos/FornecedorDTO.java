package ao.cinapse.recicla_me.core.http.dtos;

import ao.cinapse.recicla_me.core.models.Fornecedor;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@ToString
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO extends AbstractDTO<Fornecedor, FornecedorDTO>
{
    private UUID id;
    private String numeroFornecedor;
    private PessoaDTO pessoa;
    private TipoFornecedorDTO tipoFornecedor;

    @Override
    public Fornecedor cast(FornecedorDTO dto) {
        Fornecedor entity = new Fornecedor();
        BeanUtils.copyProperties(dto, entity);

        entity.setIdFornecedor(dto.getId());
        if ( dto.getTipoFornecedor() != null)
            entity.setIdTipoFornecedor( new TipoFornecedorDTO().cast(dto.getTipoFornecedor()) );
        if ( dto.getPessoa() != null)
            entity.setIdPessoa( new PessoaDTO().cast(dto.getPessoa()) );

        return entity;
    }

    @Override
    public FornecedorDTO parse(Fornecedor entity)
    {
        FornecedorDTO dto = new FornecedorDTO();
        BeanUtils.copyProperties(entity, dto);

        dto.setId( entity.getIdFornecedor() );
        if ( entity.getIdPessoa() != null)
            dto.setPessoa(PessoaDTO.builder().build().parse(entity.getIdPessoa()));
        if ( entity.getIdTipoFornecedor() != null)
            dto.setTipoFornecedor(TipoFornecedorDTO.builder().build().parse(entity.getIdTipoFornecedor()));

        return dto;
    }

    @Override
    public Fornecedor cast() {
        Fornecedor entity = new Fornecedor();
        BeanUtils.copyProperties(this, entity);

        entity.setIdFornecedor(this.getId());
        if ( this.getTipoFornecedor() != null )
            entity.setIdTipoFornecedor( new TipoFornecedorDTO().cast(this.getTipoFornecedor()) );
        if ( this.getPessoa() != null)
            entity.setIdPessoa( new PessoaDTO().cast(this.getPessoa()) );

        return entity;
    }
}
