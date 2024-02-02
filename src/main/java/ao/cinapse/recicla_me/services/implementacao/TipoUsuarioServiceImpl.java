/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.TipoUsuario;
import ao.cinapse.recicla_me.repositories.TipoUsuarioRepository;
import ao.cinapse.recicla_me.services.TipoUsuarioService;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivandro.sousa
 */
@Service
public class TipoUsuarioServiceImpl extends AbstractService<TipoUsuario, UUID> implements TipoUsuarioService
{
    @Override
    protected TipoUsuarioRepository getRepository() {
        return (TipoUsuarioRepository) super.getRepository();
    }

    @Override
    public Optional<TipoUsuario> findByCodigo(String codigo) {
        return this.getRepository().findByCodigo(codigo);
    }

    @Override
    public Boolean codigoExistente(String codigo) {
        Optional<TipoUsuario> tOptional = this.findByCodigo(codigo);
        return tOptional.isPresent();
    }
}
