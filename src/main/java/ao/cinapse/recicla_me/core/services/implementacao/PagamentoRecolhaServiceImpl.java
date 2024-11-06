package ao.cinapse.recicla_me.core.services.implementacao;

import ao.cinapse.recicla_me.core.kafka.models.TransacaoDTO;
import ao.cinapse.recicla_me.core.models.PagamentoRecolha;
import ao.cinapse.recicla_me.core.models.Publicacao;
import ao.cinapse.recicla_me.core.repositories.PagamentoRecolhaRepository;
import ao.cinapse.recicla_me.core.services.interfaces.PagamentoRecolhaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
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
}
