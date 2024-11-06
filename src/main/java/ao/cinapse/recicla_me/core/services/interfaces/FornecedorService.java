package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.Fornecedor;
import ao.cinapse.recicla_me.core.models.Pessoa;
import ao.cinapse.recicla_me.core.models.Usuario;

import java.util.Optional;

public interface FornecedorService {

    public Fornecedor criarPorUsuario(Usuario usuario) throws Exception;
    public Optional<Fornecedor> findByIdPessoa(Pessoa idPessoa) throws Exception;
}
