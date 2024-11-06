package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.Localidade;

import java.util.Optional;

public interface LocalidadeService {
    public Boolean codigoExistente( String denominacao);
    public Optional<Localidade> getByDenominacao(String denominacao );
}
