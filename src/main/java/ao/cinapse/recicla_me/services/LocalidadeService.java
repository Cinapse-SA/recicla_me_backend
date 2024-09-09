package ao.cinapse.recicla_me.services;

import ao.cinapse.recicla_me.models.Localidade;

import java.util.Optional;

public interface LocalidadeService {
    public Boolean codigoExistente( String denominacao);
    public Optional<Localidade> getByDenominacao(String denominacao );
}
