package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.EstadoPublicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstadoPublicacaoRepository extends JpaRepository<EstadoPublicacao, UUID> {
}
