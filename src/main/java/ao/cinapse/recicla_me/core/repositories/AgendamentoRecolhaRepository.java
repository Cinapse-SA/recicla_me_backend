package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.core.models.EstadoAgendamentoRecolha;
import ao.cinapse.recicla_me.core.models.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AgendamentoRecolhaRepository extends JpaRepository<AgendamentoRecolha, UUID>
{
    List<AgendamentoRecolha> findByIdPublicacao( @Param("idPublicacao") Publicacao idPublicacao);

    @Modifying
    @Query("UPDATE agendamento_recolha agr SET agr.idEstadoAgendamentoRecolha = :cancelado WHERE agr.idPublicacao = :publicacao AND agr != :agendamento")
    Integer confirmarAgendamentoRecolha(
        @Param("publicacao") Publicacao publicacao,
        @Param("cancelado") EstadoAgendamentoRecolha cancelado,
        @Param("agendamento") AgendamentoRecolha agendamento
    );
}