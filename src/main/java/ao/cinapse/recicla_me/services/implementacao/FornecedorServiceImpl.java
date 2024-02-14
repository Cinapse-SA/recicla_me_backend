package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.Fornecedor;
import ao.cinapse.recicla_me.models.Usuario;
import ao.cinapse.recicla_me.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FornecedorServiceImpl extends AbstractService<Fornecedor, UUID> implements FornecedorService
{
    @Autowired
    private TipoFornecedorServiceImpl tipoFornecedorService;

    @Override
    public Fornecedor criarPorUsuario(Usuario usuario) throws Exception
    {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNumeroFornecedor( usuario.getIdPessoa().getNif() );
        fornecedor.setIdPessoa(usuario.getIdPessoa());
        fornecedor.setIdTipoFornecedor( this.tipoFornecedorService.findByCodigo("PEQUENO_FORNECEDOR").get() );
        return this.criar(fornecedor);
    }
}
