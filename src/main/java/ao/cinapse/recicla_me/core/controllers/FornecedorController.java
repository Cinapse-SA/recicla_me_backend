package ao.cinapse.recicla_me.core.controllers;

import ao.cinapse.recicla_me.core.controllers.base.BaseController;
import ao.cinapse.recicla_me.core.http.ResponseBody;
import ao.cinapse.recicla_me.core.http.dtos.FornecedorDTO;
import ao.cinapse.recicla_me.core.models.Fornecedor;
import ao.cinapse.recicla_me.core.services.implementacao.FornecedorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
//@SecurityRequirement(name="BearerAuth")
//@Tag(name = "Fornecedor Controller")
public class FornecedorController extends BaseController<ResponseBody, FornecedorDTO, Fornecedor, UUID, FornecedorServiceImpl> {


    @Autowired
    private FornecedorDTO fornecedorDTO;

    @Override
    @Operation(
        description = "Listar os Fornecedores",
        summary = "Lista de todos os Fornecedores",
        responses = {
            @ApiResponse(
                description = "Sucesso",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Forbiden",
                responseCode = "403"
            )
        }
    )
    public ResponseEntity<ResponseBody> listar(Pageable page) {
        return this.ok(
            "Lista de Fornecedores.",
            this.fornecedorDTO.toListFromEntityList( this.getService().findAll() )
        );
    }

    @Override
    public ResponseEntity<ResponseBody> salvar(FornecedorDTO fornecedorDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBody> editar(UUID uuid, FornecedorDTO fornecedorDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseBody> deletar(UUID uuid) {
        return null;
    }


}
