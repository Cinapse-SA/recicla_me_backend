/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.UsuarioDTO;
import ao.cinapse.recicla_me.models.TipoUsuario;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
import ao.cinapse.recicla_me.models.Usuario;
import ao.cinapse.recicla_me.services.implementacao.TipoUsuarioServiceImpl;
import ao.cinapse.recicla_me.services.implementacao.UsuarioServiceImpl;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ivandro.sousa
 */
@RestController
@RequestMapping("/user")
public class UsuarioController extends BaseController<ResponseBody, UsuarioDTO, Usuario, UUID, UsuarioServiceImpl>
{
    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioServiceImpl;

    @Override
    public ResponseEntity<ResponseBody> listar( @PageableDefault(size = 100, page = 0) Pageable page )
    {
        return this.ok(
        "Lista de utilizadores.", 
            this.getService().findAllPaginado(page)
        );
    }

    @Override
    public ResponseEntity<ResponseBody> salvar(@RequestBody UsuarioDTO dto)
    {
        System.err.println( dto );
        
        Optional<TipoUsuario> tipoUsuarioOp = this.tipoUsuarioServiceImpl.findByCodigo( dto.getTipoUsuario().getCodigo() );
        if ( tipoUsuarioOp.isEmpty() )
            return this.badRequest("Tipo de utilizador é inválido.", dto);
        try 
        {
            Usuario usuario = dto.cast();
            usuario.setIdTipoUsuario( tipoUsuarioOp.get() );
            return this.ok(
                "Utilizador criado com sucesso.",
                this.getService().criar( usuario )
            );
        }
        catch (Exception e) 
        {
            return this.badRequest(
            "Erro ao criar o utilizador.", 
            e.getMessage() 
            );
        }
    }

    @Override
    public ResponseEntity<ResponseBody> editar(UUID id, UsuarioDTO dto)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<ResponseBody> deletar(UUID id)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
