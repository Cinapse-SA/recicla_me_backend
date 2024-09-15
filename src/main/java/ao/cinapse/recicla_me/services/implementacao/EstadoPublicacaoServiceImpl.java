package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.EstadoPublicacao;
import ao.cinapse.recicla_me.repositories.EstadoPublicacaoRepository;
import ao.cinapse.recicla_me.services.interfaces.EstadoPublicacaoService;
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
}
