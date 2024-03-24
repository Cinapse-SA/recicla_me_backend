package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.Material;
import ao.cinapse.recicla_me.services.MaterialService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MaterialServiceImpl extends AbstractService<Material, UUID> implements MaterialService {

}
