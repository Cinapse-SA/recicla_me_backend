package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.MaterialReciclavel;
import ao.cinapse.recicla_me.models.TipoMaterial;
import ao.cinapse.recicla_me.repositories.MaterialReciclavelRepository;
import ao.cinapse.recicla_me.services.MaterialReciclavelService;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MaterialReciclavelServiceImpl extends AbstractService<MaterialReciclavel, UUID> implements MaterialReciclavelService {

    @Override
    protected MaterialReciclavelRepository getRepository() {
        return (MaterialReciclavelRepository) super.getRepository();
    }

    @Override
    public Optional<MaterialReciclavel> findByCodigo(String codigo) {
        return this.getRepository().findByCodigo( codigo );
    }



    @Override
    public Boolean codigoExistente(String codigo) {
        return this.findByCodigo(codigo).isPresent();
    }

    @Override
    public List<MaterialReciclavel> findByIdTipoMaterial(TipoMaterial tipoMaterial) {
        return this.getRepository().findByIdTipoMaterial(tipoMaterial);
    }
}
