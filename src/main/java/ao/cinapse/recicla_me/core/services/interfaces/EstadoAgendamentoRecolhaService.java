package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.EstadoAgendamentoRecolha;

public interface EstadoAgendamentoRecolhaService {
    EstadoAgendamentoRecolha getByCodigo(String codigo);

    EstadoAgendamentoRecolha getEstadoConfirmado();

    EstadoAgendamentoRecolha getEstadoCancelado();
}
