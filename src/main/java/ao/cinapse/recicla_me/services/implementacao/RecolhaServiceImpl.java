package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.models.Recolha;
import ao.cinapse.recicla_me.repositories.RecolhaRepository;
import ao.cinapse.recicla_me.services.interfaces.RecolhaService;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RecolhaServiceImpl extends AbstractService<Recolha, UUID> implements RecolhaService
{
    @Override
    protected RecolhaRepository getRepository() {
        return (RecolhaRepository) super.getRepository();
    }

    @Override
    public Recolha criar(Recolha entidade) throws Exception {
        return super.criar(entidade);
    }

    @Override
    public Recolha salvarUsandoAgendamento(AgendamentoRecolha agendamentoRecolha) throws Exception
    {
        Recolha recolha = Recolha.builder()
                                    .horarioRecolha( agendamentoRecolha.getHorarioRecolha() )
                                    .idPublicacao(agendamentoRecolha.getIdPublicacao())
                                    .idTransportador(agendamentoRecolha.getIdTransportador())
                                    .idAgendamentoRecolha(agendamentoRecolha)
                                    .idFornecedor(agendamentoRecolha.getIdPublicacao().getIdFornecedor())
                                    .custoTotal(agendamentoRecolha.getIdPublicacao().getCustoTotal())
                                    .pesoTotal(agendamentoRecolha.getIdPublicacao().getPesoTotal())
                                    .endereco(agendamentoRecolha.getIdPublicacao().getEndereco())
                                    .latitude(agendamentoRecolha.getIdPublicacao().getLatitude())
                                    .longitude(agendamentoRecolha.getIdPublicacao().getLongitude())
                                    .build();
        return this.criar(recolha);
    }
}
