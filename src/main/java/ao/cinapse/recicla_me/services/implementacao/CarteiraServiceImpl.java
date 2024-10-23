package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.Carteira;
import ao.cinapse.recicla_me.models.Pessoa;
import ao.cinapse.recicla_me.models.Usuario;
import ao.cinapse.recicla_me.repositories.CarteiraRepository;
import ao.cinapse.recicla_me.security.UsuarioLogadoService;
import ao.cinapse.recicla_me.services.interfaces.CarteiraService;
import ao.cinapse.recicla_me.utils.CarteiraUtil;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CarteiraServiceImpl extends AbstractService<Carteira, UUID> implements CarteiraService
{
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    private Logger LOGGER = LoggerFactory.getLogger(CarteiraServiceImpl.class);

    @Override
    protected CarteiraRepository getRepository() {
        return (CarteiraRepository) super.getRepository();
    }

    @Override
    public Carteira criar(Carteira entidade) throws Exception
    {
        Optional<Carteira> carteira = this.findByIdPessoa(entidade.getIdPessoa());
        if ( carteira.isPresent() )
            return carteira.get();

        Carteira novaCarteira = this.gerarCarteiraValida();
        novaCarteira.setIdPessoa(entidade.getIdPessoa() );
        return super.criar( novaCarteira );
    }


    public Carteira gerarCarteiraValida() {
        Carteira carteira = new Carteira();
        try
        {
            Usuario usuario = this.usuarioLogadoService.getUsuario();
            String numeroCarteira = CarteiraUtil.gerarNumeroCarteira( usuario.getIdPessoa().getIdPessoa().toString() );

            Optional<Carteira> carteiraExistente = this.getRepository().findByNumeroCarteira( numeroCarteira );
            while ( carteiraExistente.isPresent() ) {
                numeroCarteira = CarteiraUtil.gerarNumeroCarteira( usuario.getIdPessoa().getIdPessoa().toString() );
                carteiraExistente = this.getRepository().findByNumeroCarteira( numeroCarteira );
            }

            carteira.setNumeroCarteira(numeroCarteira);
            carteira.setDisplayNumeroCarteira( CarteiraUtil.separarQuadrantes(numeroCarteira) );
            carteira.setMoeda("Kwanza");
            carteira.setSimboloMoeda("Kz");
            carteira.setSaldoContabilistico(0.0);
            carteira.setSaldoDisponivel(0.0);
            return carteira;
        }
        catch (Exception ex) {
            LOGGER.error("Erro ao gerar carteira válida: ", ex);
            return null;
        }
    }


    @Override
    public Optional<Carteira> findByIdPessoa(Pessoa pessoa) {
        return this.getRepository().findByIdPessoa( pessoa );
    }

    @Override
    public boolean carteiraExiste(String numeroCarteira) {
        Optional<Carteira> carteira = this.getRepository().findByNumeroCarteira( numeroCarteira );
        return carteira.isPresent();
    }

    @Override
    public Carteira criarParaUsuarioLogado() throws Exception {
        Usuario usuario = this.usuarioLogadoService.getUsuario();
        Optional<Carteira> carteira = this.findByIdPessoa(usuario.getIdPessoa());
        if ( carteira.isPresent() )
            return carteira.get();

        Carteira novaCarteira = this.gerarCarteiraValida();
        novaCarteira.setIdPessoa(usuario.getIdPessoa() );
        return this.criar( novaCarteira );
    }

    @Override
    public Carteira getMinhaCarteira() throws Exception {
        Usuario usuario = this.usuarioLogadoService.getUsuario();
        Optional<Carteira> carteira = this.findByIdPessoa(usuario.getIdPessoa());
        return carteira.orElseThrow( () -> new Exception("Não foi possível encontrar a carteira."));
    }
}
