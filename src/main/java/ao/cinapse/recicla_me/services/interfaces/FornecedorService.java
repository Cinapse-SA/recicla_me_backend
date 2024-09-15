package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.Fornecedor;
import ao.cinapse.recicla_me.models.Pessoa;
import ao.cinapse.recicla_me.models.Usuario;

import java.util.Optional;

public interface FornecedorService {

    public Fornecedor criarPorUsuario(Usuario usuario) throws Exception;
    public Optional<Fornecedor> findByIdPessoa(Pessoa idPessoa) throws Exception;
}
