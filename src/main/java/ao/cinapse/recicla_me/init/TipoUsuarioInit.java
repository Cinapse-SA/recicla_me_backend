/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.init;

import ao.cinapse.recicla_me.models.TipoUsuario;
import ao.cinapse.recicla_me.services.implementacao.TipoUsuarioServiceImpl;
import ao.cinapse.recicla_me.utils.Enums;
import jakarta.annotation.PostConstruct;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ivandro.sousa
 */
@Component
public class TipoUsuarioInit
{
    private TipoUsuarioServiceImpl service;
    
    @Autowired
    public TipoUsuarioInit( TipoUsuarioServiceImpl serviceImpl )
    {
        this.service = serviceImpl;
    }
    
    
    @PostConstruct
    protected void init() 
    {
        for ( Enums.TipoUsuario tipo : Enums.TipoUsuario.values() ) 
        {
            String codigo = this.gerarCodigo( tipo.toString() );
            if ( !this.service.codigoExistente(codigo) ) {
                TipoUsuario tipoUsuario = this.initTipoUsuario( tipo );
                try {
                    this.service.criar(tipoUsuario);
                }
                catch (Exception ex) {
                    Logger.getLogger(TipoUsuarioInit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private String gerarCodigo(String tipo )
    {
        return tipo.replaceAll(" ", "_");
    }

    private TipoUsuario initTipoUsuario(Enums.TipoUsuario tipo)
    {
        return TipoUsuario.builder()
            .codigo( gerarCodigo(tipo.toString() ) )
            .denominacao( tipo.toString() )
            .build();
    }
}
