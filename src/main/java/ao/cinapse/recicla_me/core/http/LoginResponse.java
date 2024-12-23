package ao.cinapse.recicla_me.core.http;

import ao.cinapse.recicla_me.core.http.dtos.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginResponse {
    private String token;
    private long expiresIn;
    private UsuarioDTO usuario;
}