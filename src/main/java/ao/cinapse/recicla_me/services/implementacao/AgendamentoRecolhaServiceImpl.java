package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.AgendamentoRecolha;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AgendamentoRecolhaServiceImpl extends AbstractService<AgendamentoRecolha, UUID>
{
    @Override
    public AgendamentoRecolha criar(AgendamentoRecolha entidade) throws Exception {
        return super.criar(entidade);
    }
}
