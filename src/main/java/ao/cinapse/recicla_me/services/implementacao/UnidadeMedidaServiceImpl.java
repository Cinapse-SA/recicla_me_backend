package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.UnidadeMedida;
import ao.cinapse.recicla_me.repositories.UnidadeMedidaRepository;
import ao.cinapse.recicla_me.services.UnidadeMedidaService;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UnidadeMedidaServiceImpl extends AbstractService<UnidadeMedida, UUID> implements UnidadeMedidaService
{

    @Override
    protected UnidadeMedidaRepository getRepository() {
        return (UnidadeMedidaRepository) super.getRepository();
    }

    @Override
    public Optional<UnidadeMedida> findByCodigo(String codigo) {
        return this.getRepository().findByCodigo(codigo);
    }

    @Override
    public Boolean codigoExistente(String codigo) {
        return findByCodigo(codigo).isPresent();
    }
}
