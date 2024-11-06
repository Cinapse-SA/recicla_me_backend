package ao.cinapse.recicla_me.core.init;

import ao.cinapse.recicla_me.core.models.MaterialReciclavel;
import ao.cinapse.recicla_me.core.models.TipoMaterial;
import ao.cinapse.recicla_me.core.models.UnidadeMedida;
import ao.cinapse.recicla_me.core.services.implementacao.MaterialReciclavelServiceImpl;
import ao.cinapse.recicla_me.core.services.implementacao.TipoMaterialServiceImpl;
import ao.cinapse.recicla_me.core.services.implementacao.UnidadeMedidaServiceImpl;
import ao.cinapse.recicla_me.core.utils.Enums;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class MaterialReciclavelInit implements Serializable {

    @Autowired
    private MaterialReciclavelServiceImpl materialReciclavelService;
    @Autowired
    private TipoMaterialServiceImpl tipoMaterialService;
    @Autowired
    private UnidadeMedidaServiceImpl unidadeMedidaService;

    @PostConstruct
    protected  void init()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    salvarMateriasReciclaveis();
                }
                catch (InterruptedException e) {
                    Logger.getLogger(MaterialReciclavelInit.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }).start();
    }


    private void salvarMateriasReciclaveis()
    {
        List<MaterialReciclavel> list = this.buildListPlastico();
        for ( MaterialReciclavel materialReciclavel : list )
        {
            if (this.materialReciclavelService.codigoExistente( materialReciclavel.getCodigo() ) )
                continue;
            try {
                this.materialReciclavelService.criar(materialReciclavel);
            } catch (Exception e) {
                Logger.getLogger(MaterialReciclavelInit.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    private List<MaterialReciclavel> buildListPlastico() {
        List<MaterialReciclavel> list = new ArrayList<>();

        list.add( this.initMaterialReciclavel(
            this.buildMaterial("PET - Tereftalato de Polietileno", 1200, "PET", Enums.TipoMaterial.PLASTICO)
        ));
        list.add( this.initMaterialReciclavel(
            this.buildMaterial("PEAD - Polietileno de Alta Densidade", 1500, "PEAD", Enums.TipoMaterial.PLASTICO)
        ));
        list.add( this.initMaterialReciclavel(
            this.buildMaterial("PVC - Policloreto de Vinila", 2000, "PVC", Enums.TipoMaterial.PLASTICO)
        ));
        list.add( this.initMaterialReciclavel(
            this.buildMaterial("PEBD - Polietileno de Baixa Densidade", 2500, "PEBD", Enums.TipoMaterial.PLASTICO)
        ));
        list.add( this.initMaterialReciclavel(
            this.buildMaterial("PP - Polipropileno", 3000, "PP", Enums.TipoMaterial.PLASTICO)
        ));
        list.add( this.initMaterialReciclavel(
            this.buildMaterial("PS - Poliestireno", 3500, "PS", Enums.TipoMaterial.PLASTICO)
        ));
        list.add( this.initMaterialReciclavel(
            this.buildMaterial("ND - Não Identificado", 3500, "ND", Enums.TipoMaterial.PLASTICO)
        ));

        return list;
    }

    private HashMap<String, Object> buildMaterial( String denominacao, double preco, String codigo, Enums.TipoMaterial tipoMaterial)
    {
        Optional<UnidadeMedida> unidadeMedidaOptional = this.unidadeMedidaService.findByCodigo( TabelasReferenciasInit.gerarCodigo(Enums.UnidadeMedida.Kg.toString()) );
        Optional<TipoMaterial> tipoMaterialOptional = this.tipoMaterialService.findByCodigo( TabelasReferenciasInit.gerarCodigo(tipoMaterial.toString()) );

        HashMap<String, Object> item = new HashMap<>();
        item.put("denominacao", denominacao);
        item.put("descricao", denominacao);
        item.put("codigo", codigo);
        item.put("preco", preco);
        item.put("unidadeMedida", unidadeMedidaOptional.get());
        item.put("tipoMaterial", tipoMaterialOptional.get());
        item.put("peso", 1);

        return item;
    }

    private MaterialReciclavel initMaterialReciclavel(
        Map<String, Object> item
    )
    {
        return MaterialReciclavel.builder()
                .denominacao( item.get("denominacao").toString() )
                .descricao(item.get("descricao").toString())
                .preco(Double.parseDouble(item.get("preco").toString()))
                .idTipoMaterial( (TipoMaterial) item.get("tipoMaterial") )
                .idUnidadeMedida((UnidadeMedida) item.get("unidadeMedida") )
                .codigo(item.get("codigo").toString())
                .peso(Double.parseDouble(item.get("peso").toString()))
                .build();
    }
}
