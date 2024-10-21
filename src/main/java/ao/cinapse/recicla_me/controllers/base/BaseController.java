package ao.cinapse.recicla_me.controllers.base;

import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.ResponseControllerUtils;
import ao.cinapse.recicla_me.http.dtos.AbstractDTO;
import ao.cinapse.recicla_me.services.implementacao.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author ivandro.sousa
 */
@Component
public abstract class BaseController<
        Response extends ResponseBody,
        DTO extends Object,
        E extends Object,
        ID extends Object,
        Service extends Object> extends ResponseControllerUtils
{
    @Autowired
    private Service service;


    public Service getService() {
        return service;
    }

    @GetMapping
    public ResponseEntity<Response> listar( @PageableDefault(size = 100, page = 0) Pageable page ) {
        try {
            return ok("Lista de obtida com sucesso.", ((AbstractService<E, ID>)this.service).findAll(page));
        }
        catch (Exception e) {
            return serverError("Não foi possível listar os registros.", e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> findById(@PathVariable("id") ID id) {
        try {
            return ok("Entidade de obtida com sucesso.", ((AbstractService<E, ID>)this.service).findById(id));
        }
        catch (Exception ex) {
            return serverError("Não foi possível encontrar o registro.", ex.getMessage());
        }
    }
    
    @PostMapping
    public ResponseEntity<Response> salvar(@RequestBody DTO dto) {
        System.err.println(dto);
        try
        {
            E parsevalue = ((AbstractDTO<E, DTO>)dto).cast(dto);
            E entidade = ((AbstractService<E, ID>)this.service).criar(parsevalue);
            return ok("Entidade criada com sucesso.", ((AbstractDTO<E,DTO>)dto).parse(entidade));
        }
        catch (Exception e) {
            e.printStackTrace();
            return serverError("Não foi possível salvar o registro.", e.getMessage());
        }
    }
    
    @PutMapping
    public ResponseEntity<Response> editar(ID id, @RequestBody DTO dto)
    {
        try {
            E parsevalue = ((AbstractDTO<E, DTO>)dto).cast(dto);
            E entidade = ((AbstractService<E, ID>)this.service).editar(id, parsevalue);
            return ok("Entidade alterada com sucesso.", ((AbstractDTO<E,DTO>)dto).parse(entidade));
        }
        catch (Exception e) {
            return serverError("Não foi possível alterar os registro.", e.getMessage());
        }
    }
    
    @DeleteMapping
    public ResponseEntity<Response> deletar(ID id) {
        try {
            E entidade = ((AbstractService<E, ID>)this.service).eliminar(id);
            return ok("Entidade eliminada com sucesso.", entidade);
        }
        catch (Exception e) {
            return serverError("Não foi possível alterar os registro.", e.getMessage());
        }
    }
}
