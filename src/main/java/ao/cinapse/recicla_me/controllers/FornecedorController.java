package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.FornecedorDTO;
import ao.cinapse.recicla_me.models.Fornecedor;
import ao.cinapse.recicla_me.services.implementacao.FornecedorServiceImpl;
import ao.cinapse.recicla_me.services.implementacao.TipoFornecedorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
//@SecurityRequirement(name="BearerAuth")
//@Tag(name = "Fornecedor Controller")
public class FornecedorController extends BaseController<ResponseBody, FornecedorDTO, UUID> {

    @Autowired
    private FornecedorDTO fornecedorDTO;
    @Autowired
    private FornecedorServiceImpl service;

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
            this.fornecedorDTO.toListFromEntityList( this.service.findAll() )
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
