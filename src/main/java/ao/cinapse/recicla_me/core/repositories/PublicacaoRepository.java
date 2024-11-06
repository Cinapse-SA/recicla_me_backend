package ao.cinapse.recicla_me.core.repositories;


import ao.cinapse.recicla_me.core.models.Fornecedor;
import ao.cinapse.recicla_me.core.models.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, UUID>
{
    List<Publicacao> findByIdFornecedor(Fornecedor fornecedor);
}
