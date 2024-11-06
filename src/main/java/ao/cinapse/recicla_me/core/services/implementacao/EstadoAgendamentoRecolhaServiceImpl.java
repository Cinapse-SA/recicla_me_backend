package ao.cinapse.recicla_me.core.services.implementacao;

import ao.cinapse.recicla_me.core.models.EstadoAgendamentoRecolha;
import ao.cinapse.recicla_me.core.repositories.EstadoAgendamentoRecolhaRepository;
import ao.cinapse.recicla_me.core.services.interfaces.EstadoAgendamentoRecolhaService;
import ao.cinapse.recicla_me.core.utils.Enums;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EstadoAgendamentoRecolhaServiceImpl
        extends AbstractService<EstadoAgendamentoRecolha, UUID>
        implements EstadoAgendamentoRecolhaService {

    @Override
    protected EstadoAgendamentoRecolhaRepository getRepository()
    {
        return (EstadoAgendamentoRecolhaRepository) super.getRepository();
    }

    @Override
    public EstadoAgendamentoRecolha getByCodigo(String codigo) {
        Optional<EstadoAgendamentoRecolha> estadoPublicacao = this.getRepository().findByCodigo(codigo);
        return estadoPublicacao.orElse(null);
    }

    @Override
    public EstadoAgendamentoRecolha getEstadoConfirmado() {
        Optional<EstadoAgendamentoRecolha> estadoPublicacao = this.getRepository().findByCodigo(Enums.EstadoAgendamentoRecolha.Confirmado.toString());
        return estadoPublicacao.orElse(null);
    }

    @Override
    public EstadoAgendamentoRecolha getEstadoCancelado() {
        Optional<EstadoAgendamentoRecolha> estadoPublicacao = this.getRepository().findByCodigo(Enums.EstadoAgendamentoRecolha.Cancelado.toString());
        return estadoPublicacao.orElse(null);
    }
}
