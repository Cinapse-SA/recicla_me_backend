package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.core.models.Publicacao;

import java.util.List;

public interface AgendamentoRecolhaService {

    public List<AgendamentoRecolha> findByPublicacaoId(Publicacao publicacaoId );

    AgendamentoRecolha confirmarAgendamentoRecolha(AgendamentoRecolha agendamentoRecolha);
}
