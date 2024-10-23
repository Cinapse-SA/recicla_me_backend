package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.Carteira;
import ao.cinapse.recicla_me.models.Pessoa;

import java.util.Optional;

public interface CarteiraService
{
    Optional<Carteira> findByIdPessoa(Pessoa pessoa);
    boolean carteiraExiste(String numeroCarteira);
    Carteira criarParaUsuarioLogado() throws Exception;
    Carteira getMinhaCarteira() throws Exception;
}
