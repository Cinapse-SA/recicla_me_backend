package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, UUID> {

    public Optional<Localidade> findByDenominacao( String denominacao );
}
