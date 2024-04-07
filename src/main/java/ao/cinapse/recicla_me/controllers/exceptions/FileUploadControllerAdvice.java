package ao.cinapse.recicla_me.controllers.exceptions;

import ao.cinapse.recicla_me.http.ResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class FileUploadControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                ResponseBody.builder()
                        .code(HttpStatus.EXPECTATION_FAILED.value())
                        .mensagem("Tamanho do ficheiro excessivamente grande. "+ex.getMessage())
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .data(new ArrayList<>())
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }
}
