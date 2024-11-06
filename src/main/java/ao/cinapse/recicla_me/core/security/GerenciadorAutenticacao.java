package ao.cinapse.recicla_me.core.security;

import ao.cinapse.recicla_me.core.services.implementacao.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GerenciadorAutenticacao implements AuthenticationManager
{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        try
        {
            String username = authentication.getName();
            String password = authentication.getCredentials().toString();

            UserDetails usuario = this.usuarioService.loadUserByUsername( username );
            if ( !this.passwordEncoder.matches(password, usuario.getPassword() ) )
                throw new BadCredentialsException("Credencias incorretas.");

            return new UsernamePasswordAuthenticationToken(
                authentication.getPrincipal(),
                usuario.getPassword(),
                new ArrayList<>()
            );
        }
        catch (UsernameNotFoundException exception) {
            throw new BadCredentialsException("Não foi possivel encontrar o usuário.");
        }
    }
}
