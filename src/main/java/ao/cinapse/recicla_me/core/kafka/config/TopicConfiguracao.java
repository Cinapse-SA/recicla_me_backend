package ao.cinapse.recicla_me.core.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TopicConfiguracao
{
    @Value("${spring.kafka.bootstrap-servers}")
    private String BOOTSTRAP_SERVER;

    @Bean
    public KafkaAdmin kafkaAdmin()
    {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        return new KafkaAdmin(config);
    }

}
