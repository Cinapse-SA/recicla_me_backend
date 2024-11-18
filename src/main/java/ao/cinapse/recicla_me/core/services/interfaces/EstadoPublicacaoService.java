package ao.cinapse.recicla_me.core.services.interfaces;

import ao.cinapse.recicla_me.core.models.EstadoPublicacao;

public interface EstadoPublicacaoService {
    EstadoPublicacao getByCodigo( String codigo);
    EstadoPublicacao getEstadoProntaRecolhar();

    EstadoPublicacao getEstadoRecolhido();

    EstadoPublicacao getEstadoPendente();
}
