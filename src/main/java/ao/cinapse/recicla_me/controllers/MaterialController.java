package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.http.dtos.MaterialDTO;
import ao.cinapse.recicla_me.models.Material;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("material")
public class MaterialController extends BaseController<ResponseBody, MaterialDTO, UUID>
{
    @Override
    public ResponseEntity<ResponseBody> listar(Pageable page) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBody> salvar(MaterialDTO materialDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBody> editar(UUID uuid, MaterialDTO materialDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBody> deletar(UUID uuid) {
        return null;
    }
}
