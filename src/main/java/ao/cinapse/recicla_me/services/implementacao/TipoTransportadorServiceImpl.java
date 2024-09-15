package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.TipoFornecedor;
import ao.cinapse.recicla_me.models.TipoTransportador;
import ao.cinapse.recicla_me.repositories.TipoFornecedorRepository;
import ao.cinapse.recicla_me.repositories.TipoTransportadorRepository;
import ao.cinapse.recicla_me.services.interfaces.TipoTransportadorService;
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
