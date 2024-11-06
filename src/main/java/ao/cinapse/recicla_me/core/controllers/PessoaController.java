/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.core.controllers;

import ao.cinapse.recicla_me.core.controllers.base.BaseController;
import ao.cinapse.recicla_me.core.http.ResponseBody;
import ao.cinapse.recicla_me.core.http.dtos.PessoaDTO;
import java.util.UUID;

import ao.cinapse.recicla_me.core.models.Pessoa;
import ao.cinapse.recicla_me.core.services.implementacao.PessoaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author ivandro.sousa
 */

@RestController
@RequestMapping("/pessoa")
//@SecurityRequirement(name="BearerAuth")
public class PessoaController extends BaseController<
    ResponseBody,
    PessoaDTO,
    Pessoa,
    UUID,
    PessoaServiceImpl>
{

    @Override
    public ResponseEntity<ResponseBody> listar( @PageableDefault(size = 100, page = 0) Pageable page )
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<ResponseBody> salvar(PessoaDTO dto)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<ResponseBody> editar(UUID id, PessoaDTO dto)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<ResponseBody> deletar(UUID id)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
