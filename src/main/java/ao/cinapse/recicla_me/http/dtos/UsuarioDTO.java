/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Pessoa;
import ao.cinapse.recicla_me.models.TipoUsuario;
import ao.cinapse.recicla_me.models.Usuario;
import jakarta.validation.constraints.NotNull;

import java.util.List;
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
public class UsuarioDTO extends AbstractDTO<Usuario, UsuarioDTO>
{
    private UUID id;
    
    @NotNull(message = "Campo username, não pode estar nulo.")
    private String username;
    @NotNull(message = "Campo password, não pode estar nulo.")
    private String password;
    @NotNull(message = "Campo telefone, é obrigatório")
    private String telefone;
    
    private String email;
    private Pessoa pessoa;    
    private TipoUsuario tipoUsuario;

    private List<String> authorities;

    private boolean isContaExpired;
    private boolean isContaLocked;
    private boolean isContaEnabled;

    @Override
    public Usuario cast(UsuarioDTO dto)
    {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuario, dto);
        
        usuario.setIdUsuario( dto.getId() );
        usuario.setIdPessoa( dto.getPessoa() );
        usuario.setIdTipoUsuario( dto.getTipoUsuario() );
        
        return usuario;
    }

    @Override
    public UsuarioDTO parse(Usuario entity)
    {
        UsuarioDTO dto = new UsuarioDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setId( entity.getIdUsuario() );
        dto.setPessoa(entity.getIdPessoa());
        dto.setTipoUsuario(entity.getIdTipoUsuario());
        return dto;
    }

    @Override
    public Usuario cast()
    {
        return this.cast(this);
    }

}
