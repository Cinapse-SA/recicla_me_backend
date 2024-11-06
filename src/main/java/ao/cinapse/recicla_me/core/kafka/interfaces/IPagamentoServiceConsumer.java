package ao.cinapse.recicla_me.core.kafka.interfaces;

public interface IPagamentoServiceConsumer
{
    public void confirmar(String pagamento) throws Exception;
}
