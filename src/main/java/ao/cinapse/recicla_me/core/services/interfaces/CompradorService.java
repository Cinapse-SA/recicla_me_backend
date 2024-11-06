package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.Comprador;
import ao.cinapse.recicla_me.core.models.Usuario;

public interface CompradorService {
    Comprador criarPorUsuario(Usuario usuario) throws Exception;
}
