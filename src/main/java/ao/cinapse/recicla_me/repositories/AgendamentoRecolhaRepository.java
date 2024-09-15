package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.AgendamentoRecolha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendamentoRecolhaRepository extends JpaRepository<AgendamentoRecolha, UUID> {
}
