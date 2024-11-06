package ao.cinapse.recicla_me.core.services.implementacao;

import ao.cinapse.recicla_me.core.http.dtos.PublicacaoDTO;
import ao.cinapse.recicla_me.core.models.Fornecedor;
import ao.cinapse.recicla_me.core.models.Publicacao;
import ao.cinapse.recicla_me.core.repositories.PublicacaoRepository;
import ao.cinapse.recicla_me.core.security.UsuarioLogadoService;
import ao.cinapse.recicla_me.core.services.interfaces.PublicacaoService;
import ao.cinapse.recicla_me.core.utils.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PublicacaoServiceImpl extends AbstractService<Publicacao, UUID> implements PublicacaoService
{
    @Autowired
    private MaterialPublicadoServiceImpl materialPublicadoService;
    @Autowired
    protected UsuarioLogadoService usuarioLogadoService;
    @Autowired
    private MaterialPublicadoArquivoServiceImpl materialPublicadoArquivoService;
    @Autowired
    private PontoRecolhaServiceImpl pontoRecolhaService;
    @Autowired
    private EstadoPublicacaoServiceImpl estadoPublicacaoService;

    @Override
    protected PublicacaoRepository getRepository() {
        return (PublicacaoRepository) super.getRepository();
    }

    @Override
    public List<Publicacao> findAll()
    {
        try {
            Fornecedor fornecedor = this.usuarioLogadoService.getFornecedor();
            System.err.println(fornecedor);
            if ( fornecedor != null ) {
                return this.getRepository().findByIdFornecedor( fornecedor );
            }
        }
        catch (Exception ex) {}

        return super.findAll();
    }



    @Override
    @Transactional
    public Publicacao criar(Publicacao entidade) throws Exception
    {
        Fornecedor fornecedor = this.usuarioLogadoService.getFornecedor();

        entidade.setIdFornecedor(fornecedor);
        entidade.setIdEstadoPublicacao( estadoPublicacaoService.getByCodigo(Enums.EstadoPublicacao.Pendente.toString()) );

        Publicacao entity = super.criar(entidade);

        entidade.getMaterialPublicadoList().forEach( item -> {
            item.setIdPublicacao(entity);
            try {
                this.materialPublicadoService.criar(item);
            }
            catch (Exception ex) {
                System.err.println("Salvar Material Publicado -> "+ex.getMessage());
            }
        });


        entidade.getPontoRecolhaList().forEach( item -> {
            item.setIdPublicacao(entity);
            try {
                 this.pontoRecolhaService.criar(item);
            }
            catch (Exception ex) {
                System.err.println("Salvar Ponto de Recolha -> "+ex.getMessage());
            }
        });

        return entity;
    }

    @Override
    public Publicacao salvarUsandoDTO(PublicacaoDTO dto) {
        return null;
    }

    @Override
    public Page<Publicacao> findAllProntaRecolher(Pageable page) throws Exception
    {
        Fornecedor fornecedor = this.usuarioLogadoService.getFornecedor();
        return this.getRepository().findByIdEstadoPublicacaoAndIdFornecedor(
            this.estadoPublicacaoService.getEstadoProntaRecolhar().getIdEstadoPublicacao(),
            fornecedor.getIdFornecedor(),
            page
        );
    }


    public Page<Publicacao> findAllPendentes(Pageable page) throws Exception
    {
        Fornecedor fornecedor = this.usuarioLogadoService.getFornecedor();
        return this.getRepository().findByIdEstadoPublicacaoAndIdFornecedor(
            this.estadoPublicacaoService.getEstadoPendente().getIdEstadoPublicacao(),
            fornecedor.getIdFornecedor(),
            page
        );
    }


}
