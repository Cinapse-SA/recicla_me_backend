package ao.cinapse.recicla_me.core.repositories;


import ao.cinapse.recicla_me.core.models.EstadoPublicacao;
import ao.cinapse.recicla_me.core.models.Fornecedor;
import ao.cinapse.recicla_me.core.models.Publicacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, UUID>
{
    @Query("select pub from publicacao pub where pub.idFornecedor = :fornecedor")
    List<Publicacao> findByIdFornecedor(Fornecedor fornecedor);

    @Query("select  pub from publicacao pub where pub.idEstadoPublicacao.idEstadoPublicacao = :estado AND pub.idFornecedor.idFornecedor = :fornecedor")
    Page<Publicacao> findByIdEstadoPublicacaoAndIdFornecedor(
        @Param("estado") UUID estado,
        @Param("fornecedor") UUID fornecedor,
        Pageable pageable
    );
}
