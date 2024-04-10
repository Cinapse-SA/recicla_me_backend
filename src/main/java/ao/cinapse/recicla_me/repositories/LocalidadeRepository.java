package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, UUID> {
}
