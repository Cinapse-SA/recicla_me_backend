package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.UnidadeMedida;

import java.util.Optional;

public interface UnidadeMedidaService {

    public Optional<UnidadeMedida> findByCodigo(String codigo);

    public Boolean codigoExistente( String codigo);
}
