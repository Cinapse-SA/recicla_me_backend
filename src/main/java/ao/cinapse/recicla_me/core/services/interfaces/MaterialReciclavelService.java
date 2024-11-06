package ao.cinapse.recicla_me.core.services.interfaces;


import ao.cinapse.recicla_me.core.models.MaterialReciclavel;
import ao.cinapse.recicla_me.core.models.TipoMaterial;

import java.util.List;
import java.util.Optional;

public interface MaterialReciclavelService
{
    public Optional<MaterialReciclavel> findByCodigo(String codigo);
    public Boolean codigoExistente( String codigo);
    public List<MaterialReciclavel> findByIdTipoMaterial(TipoMaterial idTipoMaterial);
}
