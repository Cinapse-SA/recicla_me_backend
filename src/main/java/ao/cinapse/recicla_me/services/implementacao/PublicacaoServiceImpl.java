package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.http.dtos.PublicacaoDTO;
import ao.cinapse.recicla_me.models.Publicacao;
import ao.cinapse.recicla_me.services.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PublicacaoServiceImpl extends AbstractService<Publicacao, UUID> implements PublicacaoService
{
    @Autowired
    private MaterialPublicadoServiceImpl materialPublicadoService;
    @Autowired
    private MaterialPublicadoArquivoServiceImpl materialPublicadoArquivoService;

    @Override
    @Transactional
    public Publicacao criar(Publicacao entidade) throws Exception
    {
        Publicacao entity = super.criar(entidade);
        
        return entity;
    }

    @Override
    public Publicacao salvarUsandoDTO(PublicacaoDTO dto) {
        return null;
    }
}
