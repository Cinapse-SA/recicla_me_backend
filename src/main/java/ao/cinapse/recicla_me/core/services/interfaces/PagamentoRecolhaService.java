package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.kafka.models.TransacaoDTO;
import ao.cinapse.recicla_me.core.models.PagamentoRecolha;

public interface PagamentoRecolhaService {
    PagamentoRecolha criarPorTransacao(TransacaoDTO dto) throws Exception;
}
