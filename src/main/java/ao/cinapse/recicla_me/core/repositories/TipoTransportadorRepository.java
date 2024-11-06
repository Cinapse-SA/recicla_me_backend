package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.TipoTransportador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TipoTransportadorRepository extends JpaRepository<TipoTransportador, UUID>
{
    Optional<TipoTransportador> findByCodigo( String codigo);
}
