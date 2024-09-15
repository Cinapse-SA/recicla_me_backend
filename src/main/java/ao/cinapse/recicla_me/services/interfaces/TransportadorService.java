package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.Fornecedor;
import ao.cinapse.recicla_me.models.Pessoa;
import ao.cinapse.recicla_me.models.Transportador;

import java.util.Optional;

public interface TransportadorService {
    Optional<Transportador> findByIdPessoa(Pessoa pessoa);
}
