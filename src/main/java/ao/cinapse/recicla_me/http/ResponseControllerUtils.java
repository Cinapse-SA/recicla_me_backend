package ao.cinapse.recicla_me.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class ResponseControllerUtils
{
    public ResponseEntity<ResponseBody> created( String mensagem, Object data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.CREATED);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status( HttpStatus.CREATED).body(responseBody );
    }
    
    public ResponseEntity<ResponseBody> ok( String mensagem, Object data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.OK);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok( responseBody );
    }
    
    public ResponseEntity<ResponseBody> badRequest( String mensagem, Object data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.BAD_REQUEST);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.ok( responseBody );
    }
    
    public ResponseEntity<ResponseBody> naoEncontrado( String mensagem, Object data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.NOT_FOUND);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body(responseBody );
    }

    public ResponseEntity<ResponseBody> unauthorized( String mensagem) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.UNAUTHORIZED);
        responseBody.setData( new ArrayList());
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.UNAUTHORIZED.value());
        return ResponseEntity.status( HttpStatus.UNAUTHORIZED ).body(responseBody );
    }
}
