package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.models.EstadoAgendamentoRecolha;
import ao.cinapse.recicla_me.models.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AgendamentoRecolhaRepository extends JpaRepository<AgendamentoRecolha, UUID>
{
    List<AgendamentoRecolha> findByIdPublicacao( @Param("idPublicacao") Publicacao idPublicacao);

    @Query("UPDATE agendamento_recolha agr SET agr.idEstadoAgendamentoRecolha = :cancelado WHERE agr.idPublicacao = :publicacao AND agr = :agendamento")
    boolean confirmarAgendamentoRecolha(
        @Param("publicacao") Publicacao publicacao,
        @Param("cancelado") EstadoAgendamentoRecolha cancelado,
        @Param("agendamento") AgendamentoRecolha agendamento
    );
}