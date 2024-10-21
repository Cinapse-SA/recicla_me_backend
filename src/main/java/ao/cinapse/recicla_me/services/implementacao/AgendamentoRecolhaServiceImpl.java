package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.*;
import ao.cinapse.recicla_me.repositories.AgendamentoRecolhaRepository;
import ao.cinapse.recicla_me.security.UsuarioLogadoService;
import ao.cinapse.recicla_me.services.interfaces.AgendamentoRecolhaService;
import ao.cinapse.recicla_me.utils.Enums;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgendamentoRecolhaServiceImpl extends AbstractService<AgendamentoRecolha, UUID> implements AgendamentoRecolhaService
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
    protected AgendamentoRecolhaRepository getRepository() {
        return (AgendamentoRecolhaRepository) super.getRepository();
    }

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

    @Override
    public List<AgendamentoRecolha> findByPublicacaoId(Publicacao publicacaoId)
    {
        return this.getRepository().findByIdPublicacao( publicacaoId );
    }

    @Override
    @Transactional
    public AgendamentoRecolha confirmarAgendamentoRecolha(AgendamentoRecolha agendamentoRecolha) {
        Optional<AgendamentoRecolha> entity = this.findById(agendamentoRecolha.getIdAgendamentoRecolha());
        if ( entity.isEmpty() )
            throw new EntityNotFoundException("Não foi possível encontrar o agendamento da recolha");
        Publicacao publicacao = entity.get().getIdPublicacao();

        this.getRepository().confirmarAgendamentoRecolha(
            publicacao,
            estadoAgendamentoRecolhaService.getEstadoCancelado(),
            entity.get()
        );

        EstadoAgendamentoRecolha estadoAgendamentoRecolha = this.estadoAgendamentoRecolhaService.getEstadoConfirmado();
        entity.get().setIdEstadoAgendamentoRecolha( estadoAgendamentoRecolha );
        return this.getRepository().save( entity.get() );
    }

}
