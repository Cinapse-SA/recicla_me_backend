package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.UnidadeMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, UUID> {

    public Optional<UnidadeMedida> findByCodigo(String codigo);

}
