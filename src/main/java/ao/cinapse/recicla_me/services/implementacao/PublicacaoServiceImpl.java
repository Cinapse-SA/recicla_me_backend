package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.http.dtos.MaterialPublicadoDTO;
import ao.cinapse.recicla_me.http.dtos.PublicacaoDTO;
import ao.cinapse.recicla_me.models.Fornecedor;
import ao.cinapse.recicla_me.models.MaterialPublicado;
import ao.cinapse.recicla_me.models.Publicacao;
import ao.cinapse.recicla_me.security.UsuarioLogadoService;
import ao.cinapse.recicla_me.services.PublicacaoService;
import ao.cinapse.recicla_me.utils.Enums;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Transactional
    public Publicacao criar(Publicacao entidade) throws Exception
    {
        Fornecedor fornecedor = this.usuarioLogadoService.getFornecedor();

        entidade.setIdEstadoPublicacao( estadoPublicacaoService.getByCodigo(Enums.EstadoPublicacao.Novo.toString()) );
        entidade.setIdFornecedor(fornecedor);
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
}
