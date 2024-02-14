package ao.cinapse.recicla_me.services;

import ao.cinapse.recicla_me.models.Fornecedor;
import ao.cinapse.recicla_me.models.Usuario;

public interface FornecedorService {

    public Fornecedor criarPorUsuario(Usuario usuario) throws Exception;
}
