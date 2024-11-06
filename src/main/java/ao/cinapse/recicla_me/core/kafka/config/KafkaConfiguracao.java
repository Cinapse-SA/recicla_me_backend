package ao.cinapse.recicla_me.core.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguracao
{
    @Value("${spring.kafka.bootstrap-servers}")
    private String BOOTSTRAP_SERVER;

    @Value("${spring.kafka.consumer.group-id}")
    private String KAFKA_GROUP_ID;


    @Bean
    public ProducerFactory<String, String> producerConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public ConsumerFactory<String, String> consumerConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.BOOTSTRAP_SERVER);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, this.KAFKA_GROUP_ID);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>( producerConfig() );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        containerFactory.setConsumerFactory( consumerConfig() );
        return containerFactory;
    }
}
