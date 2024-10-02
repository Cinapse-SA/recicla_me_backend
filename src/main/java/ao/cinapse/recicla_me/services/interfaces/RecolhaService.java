package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.models.Recolha;

public interface RecolhaService {
    public Recolha salvarUsandoAgendamento(AgendamentoRecolha agendamentoRecolha) throws Exception;
}
