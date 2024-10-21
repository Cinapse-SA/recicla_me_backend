package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.EstadoAgendamentoRecolha;

public interface EstadoAgendamentoRecolhaService {
    EstadoAgendamentoRecolha getByCodigo(String codigo);

    EstadoAgendamentoRecolha getEstadoConfirmado();

    EstadoAgendamentoRecolha getEstadoCancelado();
}
