package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.*;
import ao.cinapse.recicla_me.repositories.TransportadorRepository;
import ao.cinapse.recicla_me.services.interfaces.TransportadorService;
import ao.cinapse.recicla_me.utils.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransportadorServiceImpl extends AbstractService<Transportador, UUID> implements TransportadorService
{
    @Autowired
    private TipoTransportadorServiceImpl tipoTransportadorService;


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

    @Override
    public Transportador criarPorUsuario(Usuario usuario) throws Exception
    {
        Transportador transportador = new Transportador();
        transportador.setNumeroTransportador( usuario.getIdPessoa().getNif() );
        transportador.setIdPessoa(usuario.getIdPessoa());
        transportador.setIdTipoTransportador( this.tipoTransportadorService.findByCodigo(Enums.TipoTransportador.PEQUENO_TRANSPORTADOR.toString()).get() );
        return this.criar(transportador);
    }
}
