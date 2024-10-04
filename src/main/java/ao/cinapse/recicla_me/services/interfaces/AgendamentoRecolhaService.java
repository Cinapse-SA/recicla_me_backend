package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.models.Publicacao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AgendamentoRecolhaService {

    public List<AgendamentoRecolha> findByPublicacaoId(Publicacao publicacaoId );
}
