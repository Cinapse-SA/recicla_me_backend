/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author ivandro.sousa
 */
@Getter
@Setter
@ToString
@Component
public class PessoaDTO extends AbstractDTO<Pessoa, PessoaDTO>
{
    private UUID id;
    
    @NotNull(message = "Nome, não pode estar nulo.")
    @NotBlank(message = "Nome, não pode estar vazio.")
    private String nome;
    
    @NotNull(message = "NIF ou Bilhete de Identidade, não pode estar nulo.")
    @NotBlank(message = "NIF, não pode estar vazio.")
    private String nif;
    
    @Override
    public Pessoa cast(PessoaDTO dto)
    {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(dto, pessoa);
        pessoa.setIdPessoa( dto.getId() );
        return pessoa;
    }

    @Override
    public PessoaDTO parse(Pessoa entity)
    {
        PessoaDTO dto = new PessoaDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setId( entity.getIdPessoa());
        return dto;
    }


    @Override
    public Pessoa cast()
    {
        return this.cast(this);
    }
    
}
