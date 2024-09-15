package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.TipoUsuario;
import ao.cinapse.recicla_me.models.UnidadeMedida;

import java.util.Optional;

public interface UnidadeMedidaService {

    public Optional<UnidadeMedida> findByCodigo(String codigo);

    public Boolean codigoExistente( String codigo);
}
