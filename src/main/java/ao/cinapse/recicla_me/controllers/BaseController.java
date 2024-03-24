package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.http.ResponseControllerUtils;
import ao.cinapse.recicla_me.services.implementacao.AbstractService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController<Response extends Object, DTO extends  Object, ID extends Object> extends ResponseControllerUtils
{
    @GetMapping
    public abstract ResponseEntity<Response> listar( @PageableDefault(size = 100, page = 0) Pageable page );
    
    @PostMapping
    public abstract ResponseEntity<Response> salvar(@RequestBody DTO dto);
    
    @PutMapping
    public abstract ResponseEntity<Response> editar(ID id, @RequestBody DTO dto);
    
    @DeleteMapping
    public abstract ResponseEntity<Response> deletar(ID id);
}
