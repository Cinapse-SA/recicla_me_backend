package ao.cinapse.recicla_me.core.services.implementacao;

import ao.cinapse.recicla_me.core.models.TipoTransportador;
import ao.cinapse.recicla_me.core.repositories.TipoTransportadorRepository;
import ao.cinapse.recicla_me.core.services.interfaces.TipoTransportadorService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TipoTransportadorServiceImpl extends AbstractService<TipoTransportador, UUID> implements TipoTransportadorService {

    @Override
    protected TipoTransportadorRepository getRepository() {
        return (TipoTransportadorRepository) super.getRepository();
    }

    @Override
    public Optional<TipoTransportador> findByCodigo(String codigo) {
        return this.getRepository().findByCodigo(codigo);
    }

    @Override
    public Boolean codigoExistente(String codigo) {
        Optional<TipoTransportador> existente = this.findByCodigo(codigo);
        return existente.isPresent();
    }

}
