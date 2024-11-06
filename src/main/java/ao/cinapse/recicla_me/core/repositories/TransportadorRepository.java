package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.Pessoa;
import ao.cinapse.recicla_me.core.models.Transportador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransportadorRepository extends JpaRepository<Transportador, UUID> {
    Optional<Transportador> findByIdPessoa(Pessoa pessoa);
}
