package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID>
{
    @Query("SELECT F FROM Fornecedor F WHERE F.idPessoa.idPessoa = :idPessoa")
    Optional<Fornecedor> findByIdPessoa(@Param(("idPessoa")) UUID idPessoa);
}
