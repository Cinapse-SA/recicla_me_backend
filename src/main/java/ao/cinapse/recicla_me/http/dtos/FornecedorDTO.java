package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Fornecedor;
import ao.cinapse.recicla_me.models.Pessoa;
import ao.cinapse.recicla_me.models.TipoFornecedor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
        entity.setIdTipoFornecedor( new TipoFornecedorDTO().cast(dto.getTipoFornecedor()) );
        entity.setIdPessoa( new PessoaDTO().cast(dto.getPessoa()) );

        return entity;
    }

    @Override
    public FornecedorDTO parse(Fornecedor entity)
    {
        FornecedorDTO dto = new FornecedorDTO();
        BeanUtils.copyProperties(entity, dto);

        PessoaDTO pessoaDTO = new PessoaDTO().parse(entity.getIdPessoa());
        TipoFornecedorDTO tipoFornecedorDTO = new TipoFornecedorDTO().parse(entity.getIdTipoFornecedor());

        dto.setId( entity.getIdFornecedor() );
        dto.setPessoa(pessoaDTO);
        dto.setTipoFornecedor(tipoFornecedorDTO);

        return dto;
    }

    @Override
    public Fornecedor cast() {
        Fornecedor entity = new Fornecedor();
        BeanUtils.copyProperties(this, entity);

        entity.setIdFornecedor(this.getId());
        entity.setIdTipoFornecedor( new TipoFornecedorDTO().cast(this.getTipoFornecedor()) );
        entity.setIdPessoa( new PessoaDTO().cast(this.getPessoa()) );

        return entity;
    }
}
