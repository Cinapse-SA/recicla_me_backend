package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.core.models.EstadoAgendamentoRecolha;
import ao.cinapse.recicla_me.core.models.Publicacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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

    @Query("SELECT ar FROM agendamento_recolha ar WHERE ar.horarioRecolha < :agora")
    List<AgendamentoRecolha> findAgendamentosActivos(@Param("agora") LocalDateTime agora );
}