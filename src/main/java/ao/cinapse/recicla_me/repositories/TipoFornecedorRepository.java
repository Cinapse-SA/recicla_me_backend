package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.TipoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TipoFornecedorRepository extends JpaRepository<TipoFornecedor, UUID>
{
    public Optional<TipoFornecedor> findByCodigo( String codigo);
}
