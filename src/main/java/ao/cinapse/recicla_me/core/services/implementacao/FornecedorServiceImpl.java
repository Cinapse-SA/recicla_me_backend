package ao.cinapse.recicla_me.core.services.implementacao;

import ao.cinapse.recicla_me.core.models.Fornecedor;
import ao.cinapse.recicla_me.core.models.Pessoa;
import ao.cinapse.recicla_me.core.models.Usuario;
import ao.cinapse.recicla_me.core.repositories.FornecedorRepository;
import ao.cinapse.recicla_me.core.services.interfaces.FornecedorService;
import ao.cinapse.recicla_me.core.utils.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FornecedorServiceImpl extends AbstractService<Fornecedor, UUID> implements FornecedorService
{
    @Autowired
    private TipoFornecedorServiceImpl tipoFornecedorService;

    @Override
    protected FornecedorRepository getRepository() {
        return (FornecedorRepository) super.getRepository();
    }

    @Override
    public Fornecedor criarPorUsuario(Usuario usuario) throws Exception
    {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNumeroFornecedor( usuario.getIdPessoa().getNif() );
        fornecedor.setIdPessoa(usuario.getIdPessoa());
        fornecedor.setIdTipoFornecedor( this.tipoFornecedorService.findByCodigo(Enums.TipoFornecedor.PEQUENO_FORNECEDOR.toString()).get() );
        return this.criar(fornecedor);
    }

    @Override
    public Optional<Fornecedor> findByIdPessoa(Pessoa pessoa) throws Exception {
        return this.getRepository().findByIdPessoa( pessoa );
    }
}
