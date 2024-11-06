package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.PagamentoRecolha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PagamentoRecolhaRepository extends JpaRepository<PagamentoRecolha, UUID>
{
    @Query("select pr from pagamento_recolha pr where pr.idTransacao = :idTransacao")
    Optional<PagamentoRecolha> findByIdTransacao( @Param("idTransacao") String uuid);
}
