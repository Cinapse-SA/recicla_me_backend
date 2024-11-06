package ao.cinapse.recicla_me.core.services.implementacao;

import ao.cinapse.recicla_me.core.models.MaterialPublicado;
import ao.cinapse.recicla_me.core.repositories.MaterialPublicadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MaterialPublicadoServiceImpl extends AbstractService<MaterialPublicado, UUID> {

    @Autowired
    private MaterialPublicadoArquivoServiceImpl materialPublicadoArquivoService;

    @Override
    public MaterialPublicado criar(MaterialPublicado entidade) throws Exception {
        MaterialPublicado finalEntidade = ((MaterialPublicadoRepository)this.getRepository()).save(entidade);;
        entidade.getImages().forEach(item -> {
            System.err.println(item);
            try {
                item.setIdMaterialPublicado(finalEntidade);
                this.materialPublicadoArquivoService.criar(item);
            }
            catch (Exception e) {
                System.err.println("MaterialPublicadoServiceImpl -> "+e.getMessage());
            }
        });
        return entidade;
    }
}
