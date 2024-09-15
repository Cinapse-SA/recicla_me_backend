package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.TipoMaterial;
import ao.cinapse.recicla_me.repositories.TipoMaterialRepository;
import ao.cinapse.recicla_me.services.interfaces.TipoMaterialService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TipoMaterialServiceImpl extends AbstractService<TipoMaterial, UUID> implements TipoMaterialService {

    @Override
    protected TipoMaterialRepository getRepository() {
        return (TipoMaterialRepository) super.getRepository();
    }

    @Override
    public Optional<TipoMaterial> findByCodigo(String codigo)
    {
        if ( codigo == null )
            return Optional.empty();
        return this.getRepository().findByCodigo( codigo );
    }

    @Override
    public boolean codigoExistente(String codigo) {
        return this.findByCodigo(codigo).isPresent();
    }
}
