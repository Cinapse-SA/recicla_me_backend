/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.init;

import ao.cinapse.recicla_me.models.*;
import ao.cinapse.recicla_me.services.implementacao.*;
import ao.cinapse.recicla_me.utils.Enums;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivandro.sousa
 */
@Component
public class TabelasReferenciasInit
{
    @Autowired
    private TipoFornecedorServiceImpl tipoFornecedorService;
    @Autowired
    private TipoMaterialServiceImpl tipoMaterialService;
    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioService;
    @Autowired
    private UnidadeMedidaServiceImpl unidadeMedidaService;
    @Autowired
    private EstadoPublicacaoServiceImpl estadoPublicacaoService;


    @PostConstruct
    protected void init() 
    {
        this.initTipoFornecedor();
        this.initTipoMaterial();
        this.initTipoUsuario();
        this.initUnidadeMedida();
        this.initEstadoPublicacao();
    }

    private void initUnidadeMedida() {
        for ( Enums.UnidadeMedida unidadeMedida : Enums.UnidadeMedida.values() )
        {
            String codigo = this.gerarCodigo( unidadeMedida.toString() );
            if ( !this.unidadeMedidaService.codigoExistente(codigo) ) {
                UnidadeMedida uni = this.initUnidadeMedida( unidadeMedida );
                try {
                    this.unidadeMedidaService.criar(uni);
                }
                catch (Exception ex) {
                    Logger.getLogger(TabelasReferenciasInit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void initTipoUsuario() {
        for ( Enums.TipoUsuario tipo : Enums.TipoUsuario.values() )
        {
            String codigo = this.gerarCodigo( tipo.toString() );
            if ( !this.tipoUsuarioService.codigoExistente(codigo) ) {
                TipoUsuario tipoUsuario = this.initTipoUsuario( tipo );
                try {
                    this.tipoUsuarioService.criar(tipoUsuario);
                }
                catch (Exception ex) {
                    Logger.getLogger(TabelasReferenciasInit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void initTipoMaterial() {
        for ( Enums.TipoMaterial tipo : Enums.TipoMaterial.values() )
        {
            String codigo = this.gerarCodigo( tipo.toString() );
            if ( !this.tipoMaterialService.codigoExistente(codigo) ) {
                TipoMaterial tipoMaterial = this.initTipoMaterial( tipo );
                try {
                    this.tipoMaterialService.criar(tipoMaterial);
                }
                catch (Exception ex) {
                    Logger.getLogger(TabelasReferenciasInit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void initTipoFornecedor()
    {
        for ( Enums.TipoFornecedor tipo : Enums.TipoFornecedor.values() )
        {
            String codigo = this.gerarCodigo( tipo.toString() );
            if ( !this.tipoFornecedorService.codigoExistente(codigo) ) {
                TipoFornecedor tipoFornecedor = this.initTipoFornecedor( tipo );
                try {
                    this.tipoFornecedorService.criar(tipoFornecedor);
                }
                catch (Exception ex) {
                    Logger.getLogger(TabelasReferenciasInit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private void initEstadoPublicacao() {
        for (Enums.EstadoPublicacao estado : Enums.EstadoPublicacao.values()) {
            String codigo = this.gerarCodigo( estado.toString() );
            if ( (this.estadoPublicacaoService.getByCodigo(codigo) == null) )
            {
                EstadoPublicacao estadoPublicacao = this.initEstadoPublicacao( estado );
                try {
                    this.estadoPublicacaoService.criar(estadoPublicacao);
                }
                catch (Exception ex) {
                    Logger.getLogger(TabelasReferenciasInit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static String gerarCodigo(String tipo ) {
        return tipo.replaceAll(" ", "_");
    }


    private TipoFornecedor initTipoFornecedor(Enums.TipoFornecedor tipo)
    {
        return TipoFornecedor.builder()
            .codigo( gerarCodigo(tipo.toString() ) )
            .denominacao( tipo.toString() )
            .build();
    }

    private TipoMaterial initTipoMaterial(Enums.TipoMaterial tipo)
    {
        return TipoMaterial.builder()
                .codigo( gerarCodigo(tipo.toString() ) )
                .denominacao( tipo.toString() )
                .descricao( tipo.toString() )
                .build();
    }

    private TipoUsuario initTipoUsuario(Enums.TipoUsuario tipo)
    {
        return TipoUsuario.builder()
                .codigo( gerarCodigo(tipo.toString() ) )
                .denominacao( tipo.toString() )
                .build();
    }

    private UnidadeMedida initUnidadeMedida(Enums.UnidadeMedida unidade ) {
        return UnidadeMedida.builder()
                .unidade(unidade.toString())
                .codigo(gerarCodigo(unidade.toString()))
                .build();
    }

    private EstadoPublicacao initEstadoPublicacao( Enums.EstadoPublicacao estado) {
        return EstadoPublicacao
                .builder()
                .codigo( estado.toString())
                .denominacao(estado.toString())
                .build();
    }
}
