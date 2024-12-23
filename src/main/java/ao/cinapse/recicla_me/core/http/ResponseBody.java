package ao.cinapse.recicla_me.core.http;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody
{
    private HttpStatus status;
    private String mensagem;
    private Object data;
    private LocalDateTime timestamp = LocalDateTime.now();
    private HashMap<String, Object> paginacao = new HashMap<>();
    private Integer code;
    
    
    @Setter
    @Getter
    @ToString
    private class Paginacao extends HashMap {
        private Boolean isEmpty;
        private Integer totalElementos;
        private Integer pagina;
        private Integer totalPaginas;
    }
}