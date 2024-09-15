/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.http.dtos.UsuarioDTO;
import ao.cinapse.recicla_me.models.Usuario;
import ao.cinapse.recicla_me.repositories.UsuarioRepository;
import ao.cinapse.recicla_me.services.interfaces.UsuarioService;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivandro.sousa
 */
@Service
public class UsuarioServiceImpl extends AbstractService<Usuario, UUID> implements UsuarioService
{
    @Autowired
    private PessoaServiceImpl pessoaServiceImpl;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TransportadorServiceImpl transportadorService;
    @Autowired
    private FornecedorServiceImpl fornecedorService;


    @Override
    protected UsuarioRepository getRepository() {
        return (UsuarioRepository) super.getRepository();
    }
    
    @Override
    public Usuario  criar(Usuario entidade) throws Exception
    {
        if ( this.findByTelefone( entidade.getTelefone()).isPresent() )
            throw new Exception("Telefone do utilizador já cadastrado.");
        if ( this.findByUsername( entidade.getUsername()).isPresent() )
            throw new Exception("NIF de utilizador já cadastrado");
        if ( this.findByEmail( entidade.getEmail() ).isPresent() && entidade.getEmail() != null && !entidade.getEmail().isEmpty() )
            throw new Exception("E-mail do utilizador já cadastrado");
        
        entidade.setIdPessoa( this.pessoaServiceImpl.criar(entidade.getIdPessoa()) );
        entidade.setPassword( this.passwordEncoder.encode(entidade.getPassword() ) );
        
        return super.criar(entidade);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return this.getRepository().findByUsername( username );
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return this.getRepository().findByEmail( email );
    }

    @Override
    public Optional<Usuario> findByTelefone(String telefone) {
        return this.getRepository().findByTelefone( telefone );
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = this.findByUsername( username );
        if ( usuario.isPresent() ) {
            return usuario.get();
        }
        throw new UsernameNotFoundException("Não foi possível encontrar o usuário.");
    }

    public Usuario autenticar(UsuarioDTO dto) throws AuthenticationException, UsernameNotFoundException
    {
        return (Usuario) this.loadUserByUsername( dto.getUsername() );
    }
}
