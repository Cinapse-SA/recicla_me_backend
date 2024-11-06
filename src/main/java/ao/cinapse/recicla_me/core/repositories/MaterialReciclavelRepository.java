package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.MaterialReciclavel;
import ao.cinapse.recicla_me.core.models.TipoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MaterialReciclavelRepository extends JpaRepository<MaterialReciclavel, UUID>
{

    Optional<MaterialReciclavel> findByCodigo(String codigo);

    List<MaterialReciclavel> findByIdTipoMaterial( @Param("idTipoMaterial") TipoMaterial idTipoMaterial);
}
