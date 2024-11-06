package ao.cinapse.recicla_me.core.security;


import ao.cinapse.recicla_me.core.models.Fornecedor;
import ao.cinapse.recicla_me.core.models.Usuario;
import ao.cinapse.recicla_me.core.services.implementacao.FornecedorServiceImpl;
import ao.cinapse.recicla_me.core.services.implementacao.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioLogadoService {

    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private FornecedorServiceImpl fornecedorService;

    public Boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails details =  (UserDetails) authentication.getPrincipal();
        return authentication.isAuthenticated();
    }

    public Usuario getUsuario() throws NoSuchElementException, BadCredentialsException {
        if ( !isLoggedIn() )
            throw new BadCredentialsException("Usuário não autenticado.");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails details =  (UserDetails) authentication.getPrincipal();
        Optional<Usuario> usuario = usuarioService.findByUsername(details.getUsername());
        return usuario.orElseThrow();
    }

    public Fornecedor getFornecedor() throws Exception {
        Usuario usuario = this.getUsuario();
        Optional<Fornecedor> fornecedor = fornecedorService.findByIdPessoa( usuario.getIdPessoa() );
        return fornecedor.orElseThrow();
    }
}
