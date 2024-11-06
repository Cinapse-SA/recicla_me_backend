package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.MaterialPublicado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MaterialPublicadoRepository extends JpaRepository<MaterialPublicado, UUID> {
}
