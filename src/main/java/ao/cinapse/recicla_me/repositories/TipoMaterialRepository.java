package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.TipoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TipoMaterialRepository extends JpaRepository<TipoMaterial, UUID>
{
    public Optional<TipoMaterial> findByCodigo(String codigo);
}
