package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.PontoRecolha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PontoRecolhaRepository extends JpaRepository<PontoRecolha, UUID> {
}
