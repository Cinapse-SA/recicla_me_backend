package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.Fornecedor;
import ao.cinapse.recicla_me.services.FornecedorService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FornecedorServiceImpl extends AbstractService<Fornecedor, UUID> implements FornecedorService {
}
