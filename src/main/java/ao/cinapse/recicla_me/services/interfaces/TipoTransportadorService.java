package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.TipoTransportador;

import java.util.Optional;

public interface TipoTransportadorService {
    Optional<TipoTransportador> findByCodigo(String  codigo);
    Boolean codigoExistente( String codigo);
}
