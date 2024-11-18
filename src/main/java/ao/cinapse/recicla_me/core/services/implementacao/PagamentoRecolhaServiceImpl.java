package ao.cinapse.recicla_me.core.services.implementacao;

import ao.cinapse.recicla_me.core.http.requests.CompletarRecolhaRequest;
import ao.cinapse.recicla_me.core.kafka.models.TransacaoDTO;
import ao.cinapse.recicla_me.core.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.core.models.PagamentoRecolha;
import ao.cinapse.recicla_me.core.models.Publicacao;
import ao.cinapse.recicla_me.core.repositories.PagamentoRecolhaRepository;
import ao.cinapse.recicla_me.core.services.interfaces.PagamentoRecolhaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class PagamentoRecolhaServiceImpl extends AbstractService<PagamentoRecolha, UUID> implements PagamentoRecolhaService
{
    @Autowired
    private PublicacaoServiceImpl publicacaoService;
    @Autowired
    private EstadoPublicacaoServiceImpl estadoPublicacaoService;
    @Autowired
    private AgendamentoRecolhaServiceImpl agendamentoRecolhaService;

    @Override
    protected PagamentoRecolhaRepository getRepository() {
        return (PagamentoRecolhaRepository)super.getRepository();
    }

    @Override
    @Transactional
    public PagamentoRecolha criarPorTransacao(TransacaoDTO dto) throws Exception
    {
        Optional<PagamentoRecolha> optional = this.getRepository().findByIdTransacao( dto.getIdTransacao() );
        if ( optional.isPresent() )
            return optional.get();

        Optional<Publicacao> publicacao = this.publicacaoService.findById( UUID.fromString(dto.getIdPublicacao()) );
        if ( publicacao.isEmpty() )
            throw new EntityNotFoundException("Não foi possível encontrar a recolha.");

        PagamentoRecolha pagamentoRecolha = new PagamentoRecolha();

        publicacao.get().setIdEstadoPublicacao( this.estadoPublicacaoService.getEstadoProntaRecolhar() );
        this.publicacaoService.editar(publicacao.get().getIdPublicacao(), publicacao.get());

        pagamentoRecolha.setIdPublicacao( publicacao.get() );

        pagamentoRecolha.setCustoTotal( dto.getCustoTotal() );
        pagamentoRecolha.setHorarioPagamento(dto.getHorarioPagamento());
        pagamentoRecolha.setIdTipoPagamento( dto.getIdTipoPagamento() );
        pagamentoRecolha.setDescricaoTipoPagamento(dto.getDescricaoTipoPagamento());

        pagamentoRecolha.setIdTransacao( dto.getIdTransacao() );
        pagamentoRecolha.setDescricaoTransacao(dto.getDescricaoTransacao());
        pagamentoRecolha.setIdEstadoTransacao( dto.getIdEstadoTransacao() );
        pagamentoRecolha.setEstadoTransacao(dto.getEstadoTransacao());

        return criar(pagamentoRecolha);
    }

    @Override
    @Transactional
    public Publicacao completarRecolha(CompletarRecolhaRequest request)
    {
        Optional<AgendamentoRecolha> agendamentoRecolha = this.agendamentoRecolhaService.findById( UUID.fromString(request.idAgendamentoRecolha() ) );
        if ( agendamentoRecolha.isEmpty() )
            throw new RuntimeException("Não foi possível encontrar um agendamento marcado.");

        Optional<Publicacao> publicacao = this.publicacaoService.findById( UUID.fromString(request.idPublicacao() ) );
        if ( publicacao.isEmpty() )
            throw new RuntimeException("Não foi possível encontrar a recolha.");

        Optional<PagamentoRecolha> pagamentoRecolha = this.getRepository().findByIdPublicacao( publicacao.get() );
        if ( pagamentoRecolha.isEmpty() )
            throw new RuntimeException("Esta recolha ainda não foi paga.");

        pagamentoRecolha.get().setIdAgendamentoRecolha(agendamentoRecolha.get());
        this.editar( pagamentoRecolha.get().getIdPagamentoRecolha(), pagamentoRecolha.get());

        publicacao.get().setIdEstadoPublicacao( this.estadoPublicacaoService.getEstadoRecolhido() );
        return publicacaoService.editar(publicacao.get().getIdPublicacao(), publicacao.get());
    }
}
