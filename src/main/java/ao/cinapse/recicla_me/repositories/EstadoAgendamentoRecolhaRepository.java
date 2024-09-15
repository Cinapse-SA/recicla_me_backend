package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.EstadoAgendamentoRecolha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EstadoAgendamentoRecolhaRepository extends JpaRepository<EstadoAgendamentoRecolha, UUID> {
    Optional<EstadoAgendamentoRecolha> findByCodigo( String codigo);
}
