package ao.cinapse.recicla_me.services;

import ao.cinapse.recicla_me.models.TipoFornecedor;

import java.util.Optional;

public interface TipoFornecedorService
{
    public Optional<TipoFornecedor> findByCodigo( String codigo);
    public Boolean codigoExistente( String codigo);
}
