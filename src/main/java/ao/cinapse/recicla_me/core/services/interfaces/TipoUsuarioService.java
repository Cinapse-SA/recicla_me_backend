/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.TipoUsuario;
import java.util.Optional;

/**
 *
 * @author ivandro.sousa
 */
public interface TipoUsuarioService
{
    public Optional<TipoUsuario> findByCodigo( String codigo);
    
    public Boolean codigoExistente( String codigo);
}
