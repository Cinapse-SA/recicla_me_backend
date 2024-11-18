package ao.cinapse.recicla_me.core.services.interfaces;


import ao.cinapse.recicla_me.core.http.dtos.PublicacaoDTO;
import ao.cinapse.recicla_me.core.http.requests.CompletarRecolhaRequest;
import ao.cinapse.recicla_me.core.models.AgendamentoRecolha;
import ao.cinapse.recicla_me.core.models.Publicacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PublicacaoService {
    public Publicacao salvarUsandoDTO(PublicacaoDTO dto);

    Page<Publicacao> findAllProntaRecolher(Pageable page) throws Exception;

}
