package ao.cinapse.recicla_me.services.interfaces;


import ao.cinapse.recicla_me.models.MaterialReciclavel;
import ao.cinapse.recicla_me.models.TipoMaterial;
import ao.cinapse.recicla_me.models.UnidadeMedida;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MaterialReciclavelService
{
    public Optional<MaterialReciclavel> findByCodigo(String codigo);
    public Boolean codigoExistente( String codigo);
    public List<MaterialReciclavel> findByIdTipoMaterial(TipoMaterial idTipoMaterial);
}
