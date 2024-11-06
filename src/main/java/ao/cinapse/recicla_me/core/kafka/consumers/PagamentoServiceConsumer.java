package ao.cinapse.recicla_me.core.kafka.consumers;

import ao.cinapse.recicla_me.core.kafka.interfaces.IPagamentoServiceConsumer;
import ao.cinapse.recicla_me.core.kafka.models.DataQueue;
import ao.cinapse.recicla_me.core.kafka.models.TransacaoDTO;

import ao.cinapse.recicla_me.core.services.implementacao.PagamentoRecolhaServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceConsumer implements IPagamentoServiceConsumer
{
    private static Logger LOGGER = LoggerFactory.getLogger(PagamentoServiceConsumer.class);
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private PagamentoRecolhaServiceImpl pagamentoRecolhaService;

    @KafkaListener(topics = "${topicos.transacao-confirmada}", groupId = "recicla-me-carteira")
    public void confirmar(String dataQueue) throws Exception
    {
        try {
            DataQueue<TransacaoDTO> dataQueueDTO = mapper.readValue(dataQueue, DataQueue.class);
            String valueTransacao = mapper.writeValueAsString(dataQueueDTO.getData());
            TransacaoDTO dto = mapper.readValue(valueTransacao, TransacaoDTO.class);


            pagamentoRecolhaService.criarPorTransacao( dto );
        }
        catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
    }
}
