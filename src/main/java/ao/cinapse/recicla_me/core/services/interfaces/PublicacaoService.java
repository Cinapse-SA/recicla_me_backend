package ao.cinapse.recicla_me.core.services.interfaces;


import ao.cinapse.recicla_me.core.http.dtos.PublicacaoDTO;
import ao.cinapse.recicla_me.core.models.Publicacao;

public interface PublicacaoService {
    public Publicacao salvarUsandoDTO(PublicacaoDTO dto);
}
