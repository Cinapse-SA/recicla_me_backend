package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.MaterialReciclavelDTO;
import ao.cinapse.recicla_me.services.implementacao.MaterialReciclavelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("material-reciclavel")
public class MaterialReciclavelController extends BaseController<ResponseBody, MaterialReciclavelDTO, UUID>
{
    @Autowired
    private MaterialReciclavelServiceImpl service;
    @Autowired
    private MaterialReciclavelDTO parser;


    @Override
    public ResponseEntity<ResponseBody> listar(Pageable page)
    {
        return this.ok(
        "Lista de Materias Reciclaveis",
            this.parser.toListFromEntityList( this.service.findAll() )
        );
    }

    @Override
    public ResponseEntity<ResponseBody> salvar(MaterialReciclavelDTO materialDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBody> editar(UUID uuid, MaterialReciclavelDTO materialDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBody> deletar(UUID uuid) {
        return null;
    }
}
