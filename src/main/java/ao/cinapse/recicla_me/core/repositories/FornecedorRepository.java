package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.Fornecedor;
import ao.cinapse.recicla_me.core.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID>
{
    Optional<Fornecedor> findByIdPessoa(Pessoa pessoa);
}
