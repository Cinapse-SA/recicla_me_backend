package ao.cinapse.recicla_me.init;

import ao.cinapse.recicla_me.models.TipoFornecedor;
import ao.cinapse.recicla_me.models.TipoMaterial;
import ao.cinapse.recicla_me.services.implementacao.TipoMaterialServiceImpl;
import ao.cinapse.recicla_me.utils.Enums;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TipoMaterialInit {

    @Autowired
    private TipoMaterialServiceImpl service;

    @PostConstruct
    protected void init()
    {
        for ( Enums.TipoMaterial tipo : Enums.TipoMaterial.values() )
        {
            String codigo = this.gerarCodigo( tipo.toString() );
            if ( !this.service.codigoExistente(codigo) ) {
                TipoMaterial tipoMaterial = this.initTipo( tipo );
                try {
                    this.service.criar(tipoMaterial);
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

    private TipoMaterial initTipo(Enums.TipoMaterial tipo)
    {
        return TipoMaterial.builder()
                .codigo( gerarCodigo(tipo.toString() ) )
                .denominacao( tipo.toString() )
                .descricao( tipo.toString() )
                .build();
    }
}
