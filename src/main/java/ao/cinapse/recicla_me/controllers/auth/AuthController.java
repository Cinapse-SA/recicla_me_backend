/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.controllers.auth;


import ao.cinapse.recicla_me.http.LoginResponse;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.ResponseControllerUtils;
import ao.cinapse.recicla_me.http.dtos.UsuarioDTO;
import ao.cinapse.recicla_me.models.TipoUsuario;
import ao.cinapse.recicla_me.models.Usuario;
import ao.cinapse.recicla_me.security.GerenciadorAutenticacao;
import ao.cinapse.recicla_me.security.JwtService;
import ao.cinapse.recicla_me.services.implementacao.FornecedorServiceImpl;
import ao.cinapse.recicla_me.services.implementacao.TipoUsuarioServiceImpl;
import ao.cinapse.recicla_me.services.implementacao.UsuarioServiceImpl;

import java.util.Optional;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author ivandro.sousa
 */
@RestController
@RequestMapping("/auth")
public class AuthController extends ResponseControllerUtils
{
    @Autowired
    private UsuarioServiceImpl service;
    @Autowired
    private FornecedorServiceImpl fornecedorService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioServiceImpl;
    @Autowired
    private UsuarioDTO usuarioDTO;

    @Autowired
    private GerenciadorAutenticacao gerenciadorAutenticacao;


    @GetMapping
    public ResponseEntity<ResponseBody> user()
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @PostMapping("/registrar")
    public ResponseEntity<ResponseBody> salvar(@RequestBody UsuarioDTO dto)
    {
        Optional<TipoUsuario> tipoUsuarioOp = this.tipoUsuarioServiceImpl.findByCodigo(dto.getTipoUsuario().getCodigo());
        if (tipoUsuarioOp.isEmpty())
            return this.badRequest("Tipo de utilizador é inválido.", dto);
        try
        {
            Usuario usuario = dto.cast();
            usuario.setIdTipoUsuario(tipoUsuarioOp.get());

            usuario = this.service.criar(usuario);
            this.fornecedorService.criarPorUsuario( usuario );

            return this.ok(
                "Utilizador criado com sucesso.",
                usuario
            );
        }
        catch (Exception e)
        {
            return this.badRequest(
                    e.getMessage(),
                dto
            );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseBody> login(@RequestBody UsuarioDTO dto)
    {
        try {
            UsernamePasswordAuthenticationToken tokenToLogin = new UsernamePasswordAuthenticationToken( dto.getUsername(), dto.getPassword());
            Authentication auth = this.gerenciadorAutenticacao.authenticate( tokenToLogin );

            Usuario usuario = this.service.autenticar(dto);
            String token = this.jwtService.gerarToken(usuario);
            LoginResponse response = new LoginResponse();
            response.setToken(token);
            response.setExpiresIn(jwtService.getExpirationTime());
            response.setUsuario( this.usuarioDTO.parse(usuario) );
            return this.ok("Login efectuado com sucesso.", response );
        }
        catch ( EntityNotFoundException | BadCredentialsException ex ) {
            return this.badRequest(ex.getMessage(), null);
        }
    }

    @GetMapping("/unauthorized")
    public ResponseEntity<ResponseBody> unauthorized() {
        return this.unauthorized("Desculpe, você não tem acesso a este recurso.");
    }

}
