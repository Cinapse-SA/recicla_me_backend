package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, UUID>
{
    public Optional<TipoPagamento> findByCodigo(@Param("codigo") String codigo );
}
