package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.http.requests.CompletarRecolhaRequest;
import ao.cinapse.recicla_me.core.kafka.models.TransacaoDTO;
import ao.cinapse.recicla_me.core.models.PagamentoRecolha;
import ao.cinapse.recicla_me.core.models.Publicacao;

public interface PagamentoRecolhaService {
    PagamentoRecolha criarPorTransacao(TransacaoDTO dto) throws Exception;

    Publicacao completarRecolha(CompletarRecolhaRequest request);
}
