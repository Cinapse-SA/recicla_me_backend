package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.Comprador;
import ao.cinapse.recicla_me.models.Usuario;

public interface CompradorService {
    Comprador criarPorUsuario(Usuario usuario) throws Exception;
}
