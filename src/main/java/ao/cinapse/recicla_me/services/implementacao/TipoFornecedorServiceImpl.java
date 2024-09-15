package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.TipoFornecedor;
import ao.cinapse.recicla_me.repositories.TipoFornecedorRepository;
import ao.cinapse.recicla_me.services.interfaces.TipoFornecedorService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TipoFornecedorServiceImpl  extends AbstractService<TipoFornecedor, UUID> implements TipoFornecedorService
{
    @Override
    protected TipoFornecedorRepository getRepository() {
        return (TipoFornecedorRepository) super.getRepository();
    }

    @Override
    public Optional<TipoFornecedor> findByCodigo(String codigo) {
        return this.getRepository().findByCodigo(codigo);
    }

    @Override
    public Boolean codigoExistente(String codigo) {
        Optional<TipoFornecedor> existente = this.findByCodigo(codigo);
        return existente.isPresent();
    }
}
