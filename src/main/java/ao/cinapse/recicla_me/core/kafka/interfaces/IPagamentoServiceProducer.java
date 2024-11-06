package ao.cinapse.recicla_me.core.kafka.interfaces;


import ao.cinapse.recicla_me.core.models.Publicacao;

import java.util.UUID;

public interface IPagamentoServiceProducer
{
    public void executar(UUID idPublicacao);
}
