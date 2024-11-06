package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.Pessoa;
import ao.cinapse.recicla_me.core.models.Transportador;
import ao.cinapse.recicla_me.core.models.Usuario;

import java.util.Optional;

public interface TransportadorService {
    Optional<Transportador> findByIdPessoa(Pessoa pessoa);
    Transportador criarPorUsuario(Usuario usuario) throws Exception;
}
