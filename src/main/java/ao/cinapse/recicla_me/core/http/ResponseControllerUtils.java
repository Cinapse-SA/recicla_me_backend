package ao.cinapse.recicla_me.core.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class ResponseControllerUtils<Response>
{
    public ResponseEntity<ResponseBody> created( String mensagem, Response data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.CREATED);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status( HttpStatus.CREATED).body(responseBody );
    }
    
    public ResponseEntity<ResponseBody> ok( String mensagem, Response data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.OK);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok( responseBody );
    }

    public ResponseEntity<ResponseBody> loading( String mensagem, Response data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.PARTIAL_CONTENT);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.PARTIAL_CONTENT.value());
        return ResponseEntity.ok( responseBody );
    }

    public ResponseEntity<ResponseBody> badRequest( String mensagem, Response data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.BAD_REQUEST);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.ok( responseBody );
    }

    public ResponseEntity<ResponseBody> serverError( String mensagem, Response data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.ok( responseBody );
    }


    public ResponseEntity<ResponseBody> naoEncontrado( String mensagem, Response data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.NOT_FOUND);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body(responseBody );
    }

    public ResponseEntity<ResponseBody> excepctationFailed( String mensagem, Response data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus(HttpStatus.EXPECTATION_FAILED);
        responseBody.setData( data );
        responseBody.setMensagem( mensagem );
        responseBody.setCode(HttpStatus.EXPECTATION_FAILED.value());
        return ResponseEntity.status( HttpStatus.EXPECTATION_FAILED ).body(responseBody );
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
