package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.models.Transportador;
import ao.cinapse.recicla_me.models.Usuario;
import ao.cinapse.recicla_me.security.UsuarioLogadoService;
import ao.cinapse.recicla_me.utils.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AgendamentoRecolhaServiceImpl extends AbstractService<AgendamentoRecolha, UUID>
{
    @Autowired
    private TransportadorServiceImpl transportadorService;
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;
    @Autowired
    private EstadoAgendamentoRecolhaServiceImpl estadoAgendamentoRecolhaService;
    @Autowired
    private PublicacaoServiceImpl publicacaoService;

    @Override
    @Transactional
    public AgendamentoRecolha criar(AgendamentoRecolha entidade) throws Exception
    {
        Usuario usuario = this.usuarioLogadoService.getUsuario();
        Optional<Transportador> transportador = this.transportadorService.findByIdPessoa( usuario.getIdPessoa() );

        transportador.ifPresentOrElse(entidade::setIdTransportador, () -> {
            throw new RuntimeException("Não foi possível encontrar o transportador");
        });
        entidade.setIdEstadoAgendamentoRecolha(estadoAgendamentoRecolhaService.getByCodigo(Enums.EstadoAgendamentoRecolha.Agendado.toString()));
        AgendamentoRecolha recolha = super.criar(entidade);
        recolha.setIdPublicacao( this.publicacaoService.findById( entidade.getIdPublicacao().getIdPublicacao()).get());
        return recolha;
    }
}
