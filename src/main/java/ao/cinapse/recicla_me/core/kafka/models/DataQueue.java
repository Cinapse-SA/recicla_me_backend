package ao.cinapse.recicla_me.core.kafka.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataQueue<T> {
    private Boolean sucesso;
    private String mensagem;
    private T data;
}
