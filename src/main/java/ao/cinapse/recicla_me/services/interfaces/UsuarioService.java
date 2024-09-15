/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


/**
 *
 * @author ivandro.sousa
 */
public interface UsuarioService extends UserDetailsService
{
    //public Usuario salvarTransportador( Usuario usuario );
    
    public Optional<Usuario> findByUsername( String username );
    public Optional<Usuario> findByEmail( String username );
    public Optional<Usuario> findByTelefone( String username );

    void construirPerfil(Usuario usuario) throws Exception;
}
