package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.TipoMaterialDTO;
import ao.cinapse.recicla_me.models.TipoMaterial;
import ao.cinapse.recicla_me.services.implementacao.TipoMaterialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipo-material")
public class TipoMaterialController extends BaseController<ResponseBody, TipoMaterialDTO, TipoMaterial> {


    @Autowired
    private  TipoMaterialDTO dto;

    @Autowired
    private TipoMaterialServiceImpl service;

    @Override
    public ResponseEntity<ResponseBody> listar(Pageable page) {
        return this.ok( "Lista de Tipos de Material", this.dto.toListFromEntityList( service.findAll()) );
    }

    @Override
    public ResponseEntity<ResponseBody> salvar(TipoMaterialDTO tipoMaterialDTO)
    {
        try  {
            return this.ok("Tipo de Material salvo com sucesso.", this.dto.parse( this.service.criar(tipoMaterialDTO.cast()) ) );
        }
        catch (Exception e) {
            return this.serverError("Não foi possível executar a operação", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ResponseBody> editar(TipoMaterial tipoMaterial, TipoMaterialDTO tipoMaterialDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBody> deletar(TipoMaterial tipoMaterial) {
        return null;
    }
}
