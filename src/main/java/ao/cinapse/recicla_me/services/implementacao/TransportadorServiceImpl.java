package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.Fornecedor;
import ao.cinapse.recicla_me.models.Pessoa;
import ao.cinapse.recicla_me.models.Transportador;
import ao.cinapse.recicla_me.repositories.TransportadorRepository;
import ao.cinapse.recicla_me.services.interfaces.TransportadorService;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransportadorServiceImpl extends AbstractService<Transportador, UUID> implements TransportadorService
{
    @Override
    protected TransportadorRepository getRepository() {
        return (TransportadorRepository) super.getRepository();
    }

    @Override
    public Transportador criar(Transportador entidade) throws Exception
    {
        return super.criar(entidade);
    }

    @Override
    public Optional<Transportador> findByIdPessoa(Pessoa pessoa) {
        return this.getRepository().findByIdPessoa(pessoa);
    }
}
