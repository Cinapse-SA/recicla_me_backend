package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.core.models.Publicacao;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AgendamentoRecolhaService {

    public List<AgendamentoRecolha> findByPublicacaoId(Publicacao publicacaoId );

    AgendamentoRecolha confirmarAgendamentoRecolha(AgendamentoRecolha agendamentoRecolha);

    List<AgendamentoRecolha> findAgendamentosActivos(String publicacaoId, Pageable page);
}
