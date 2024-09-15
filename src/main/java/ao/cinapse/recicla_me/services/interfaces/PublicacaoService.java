package ao.cinapse.recicla_me.services.interfaces;


import ao.cinapse.recicla_me.http.dtos.PublicacaoDTO;
import ao.cinapse.recicla_me.models.Publicacao;

public interface PublicacaoService {
    public Publicacao salvarUsandoDTO(PublicacaoDTO dto);
}
