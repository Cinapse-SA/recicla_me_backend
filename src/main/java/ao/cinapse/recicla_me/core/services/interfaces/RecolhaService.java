package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.core.models.Recolha;

public interface RecolhaService {
    public Recolha salvarUsandoAgendamento(AgendamentoRecolha agendamentoRecolha) throws Exception;
}
