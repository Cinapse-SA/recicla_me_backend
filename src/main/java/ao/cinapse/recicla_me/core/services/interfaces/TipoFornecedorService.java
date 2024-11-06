package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.TipoFornecedor;

import java.util.Optional;

public interface TipoFornecedorService
{
    public Optional<TipoFornecedor> findByCodigo( String codigo);
    public Boolean codigoExistente( String codigo);
}
