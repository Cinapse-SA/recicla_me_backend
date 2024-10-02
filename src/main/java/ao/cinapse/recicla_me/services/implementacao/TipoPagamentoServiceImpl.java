package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.TipoPagamento;
import ao.cinapse.recicla_me.repositories.TipoPagamentoRepository;
import ao.cinapse.recicla_me.services.interfaces.TipoPagamentoService;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoPagamentoServiceImpl  extends AbstractService<TipoPagamento, UUID> implements TipoPagamentoService
{
    @Override
    protected TipoPagamentoRepository getRepository() {
        return (TipoPagamentoRepository) super.getRepository();
    }

    @Override
    public Optional<TipoPagamento> findByCodigo(String codigo) {
        Optional<TipoPagamento> tipo = this.getRepository().findByCodigo( codigo );
        return tipo;
    }

    @Override
    public Boolean codigoExistente(String codigo)  {
        Optional<TipoPagamento> tipo = this.findByCodigo(codigo);
        return tipo.isPresent();
    }
}
