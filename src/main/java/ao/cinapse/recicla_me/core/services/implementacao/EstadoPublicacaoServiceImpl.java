package ao.cinapse.recicla_me.core.services.implementacao;

import ao.cinapse.recicla_me.core.models.EstadoPublicacao;
import ao.cinapse.recicla_me.core.repositories.EstadoPublicacaoRepository;
import ao.cinapse.recicla_me.core.services.interfaces.EstadoPublicacaoService;
import ao.cinapse.recicla_me.core.utils.Enums;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EstadoPublicacaoServiceImpl extends AbstractService<EstadoPublicacao, UUID> implements EstadoPublicacaoService
{
    @Override
    protected EstadoPublicacaoRepository getRepository() {
        return (EstadoPublicacaoRepository) super.getRepository();
    }

    @Override
    public EstadoPublicacao getByCodigo(String codigo) {
        Optional<EstadoPublicacao> estadoPublicacao = this.getRepository().findByCodigo(codigo);
        return estadoPublicacao.orElse(null);
    }

    @Override
    public EstadoPublicacao getEstadoProntaRecolhar() {
        return this.getByCodigo(Enums.EstadoPublicacao.Pronta_Recolher.toString() );
    }

    @Override
    public EstadoPublicacao getEstadoRecolhido() {
        return this.getByCodigo(Enums.EstadoPublicacao.Recolhida.toString() );
    }

    @Override
    public EstadoPublicacao getEstadoPendente() {
        return this.getByCodigo(Enums.EstadoPublicacao.Pendente.toString() );
    }
}
