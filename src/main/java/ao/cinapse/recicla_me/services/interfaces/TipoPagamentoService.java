package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.TipoPagamento;
import ao.cinapse.recicla_me.models.TipoUsuario;

import java.util.Optional;

public interface TipoPagamentoService
{
    public Optional<TipoPagamento> findByCodigo(String codigo);
    public Boolean codigoExistente( String codigo);
}
