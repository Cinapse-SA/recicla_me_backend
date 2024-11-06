package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.TipoTransportador;

import java.util.Optional;

public interface TipoTransportadorService {
    Optional<TipoTransportador> findByCodigo(String  codigo);
    Boolean codigoExistente( String codigo);
}
