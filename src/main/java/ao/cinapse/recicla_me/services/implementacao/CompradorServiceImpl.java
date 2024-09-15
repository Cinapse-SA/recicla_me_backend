package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.Comprador;
import ao.cinapse.recicla_me.models.Transportador;
import ao.cinapse.recicla_me.models.Usuario;
import ao.cinapse.recicla_me.services.interfaces.CompradorService;
import ao.cinapse.recicla_me.utils.Enums;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompradorServiceImpl extends AbstractService<Comprador, UUID> implements CompradorService
{
    @Override
    public Comprador criarPorUsuario(Usuario usuario) throws Exception
    {
        Comprador transportador = new Comprador();
        transportador.setNumeroComprador( usuario.getIdPessoa().getNif() );
        transportador.setIdPessoa(usuario.getIdPessoa());
        return this.criar(transportador);
    }
}
