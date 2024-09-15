package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.MaterialReciclavelDTO;
import ao.cinapse.recicla_me.models.MaterialReciclavel;
import ao.cinapse.recicla_me.models.TipoMaterial;
import ao.cinapse.recicla_me.services.implementacao.MaterialReciclavelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("material-reciclavel")
public class MaterialReciclavelController extends BaseController<
    ResponseBody,
    MaterialReciclavelDTO,
    MaterialReciclavel,
    UUID,
    MaterialReciclavelServiceImpl>
{
    @Autowired
    private MaterialReciclavelDTO parser;

    @Override
    public ResponseEntity<ResponseBody> listar(Pageable page)
    {
        return this.ok(
        "Lista de Materias Reciclaveis",
            this.parser.toListFromEntityList( this.getService().findAll() )
        );
    }

    @GetMapping("/find-by-tipo-material")
    public ResponseEntity<ResponseBody> findByTipoMaterial( @RequestParam("idTipoMaterial") String idTipoMaterial ) {
        TipoMaterial tipoMaterial = TipoMaterial.builder().idTipoMaterial(UUID.fromString( idTipoMaterial)).build();
        List<MaterialReciclavel> list = this.getService().findByIdTipoMaterial( tipoMaterial );
        return this.ok("Lista de Materiais recicláveis.", this.parser.toListFromEntityList(list) );
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
