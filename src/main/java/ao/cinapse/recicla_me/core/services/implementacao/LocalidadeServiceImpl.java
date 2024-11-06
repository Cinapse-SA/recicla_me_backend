package ao.cinapse.recicla_me.core.services.implementacao;


import ao.cinapse.recicla_me.core.models.Localidade;
import ao.cinapse.recicla_me.core.repositories.LocalidadeRepository;
import ao.cinapse.recicla_me.core.services.interfaces.LocalidadeService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LocalidadeServiceImpl extends AbstractService<Localidade, UUID> implements LocalidadeService
{
    @Override
    protected LocalidadeRepository getRepository() {
        return (LocalidadeRepository) super.getRepository();
    }



    @Override
    public Boolean codigoExistente(String denominacao) {
        return this.getByDenominacao(denominacao).isPresent();
    }

    @Override
    public Optional<Localidade> getByDenominacao(String denominacao) {
        Optional<Localidade> localidade = this.getRepository().findByDenominacao(denominacao);
        return localidade;
    }
}
