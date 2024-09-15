package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.TipoMaterial;

import java.util.Optional;

public interface TipoMaterialService
{
    public Optional<TipoMaterial> findByCodigo(String codigo );
    public boolean codigoExistente( String codigo );
}
