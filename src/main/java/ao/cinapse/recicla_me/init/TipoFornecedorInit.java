/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.init;

import ao.cinapse.recicla_me.models.TipoFornecedor;
import ao.cinapse.recicla_me.services.implementacao.TipoFornecedorServiceImpl;
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
public class TipoFornecedorInit
{
    private TipoFornecedorServiceImpl service;

    @Autowired
    public TipoFornecedorInit(TipoFornecedorServiceImpl serviceImpl )
    {
        this.service = serviceImpl;
    }
    
    
    @PostConstruct
    protected void init() 
    {
        for ( Enums.TipoFornecedor tipo : Enums.TipoFornecedor.values() )
        {
            String codigo = this.gerarCodigo( tipo.toString() );
            if ( !this.service.codigoExistente(codigo) ) {
                TipoFornecedor tipoFornecedor = this.initTipoFornecedor( tipo );
                try {
                    this.service.criar(tipoFornecedor);
                }
                catch (Exception ex) {
                    Logger.getLogger(TipoFornecedorInit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private String gerarCodigo(String tipo )
    {
        return tipo.replaceAll(" ", "_");
    }

    private TipoFornecedor initTipoFornecedor(Enums.TipoFornecedor tipo)
    {
        return TipoFornecedor.builder()
            .codigo( gerarCodigo(tipo.toString() ) )
            .denominacao( tipo.toString() )
            .build();
    }
}
