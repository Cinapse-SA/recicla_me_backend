package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.Comprador;
import ao.cinapse.recicla_me.services.interfaces.CompradorService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompradorServiceImpl extends AbstractService<Comprador, UUID> implements CompradorService {
}
