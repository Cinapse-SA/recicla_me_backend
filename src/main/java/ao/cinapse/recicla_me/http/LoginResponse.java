package ao.cinapse.recicla_me.http;

import ao.cinapse.recicla_me.http.dtos.UsuarioDTO;
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