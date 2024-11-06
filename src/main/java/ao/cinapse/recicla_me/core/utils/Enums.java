/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.core.utils;

/**
 *
 * @author ivandro.sousa
 */
public class Enums
{
    public enum TipoUsuario {
        FORNECEDOR, TRANSPORTADOR, COMPRADOR
    };

    public enum TipoFornecedor {
        PEQUENO_FORNECEDOR, MEDIO_FORNECEDOR, GRANDE_FORNECEDOR
    };

    public enum TipoTransportador {
        PEQUENO_TRANSPORTADOR, MEDIO_TRANSPORTADOR, GRANDE_TRANSPORTADOR
    };

    public enum TipoMaterial {
        PLASTICO, FERRO, VIDRO, PAPELAO, MADEIRA
    }

    public enum UnidadeMedida {
        Kg, Ton, grama
    }

    public enum EstadoPublicacao {
        Novo, Pendente, Por_Verificar, Recusada, Eliminada, Arquivada, Pronta_Recolher, Recolhida
    }

    public enum EstadoAgendamentoRecolha {
        Agendado, Expirado, Executado, Cancelado, Confirmado
    }

    public enum TipoPagamento {
        Pagamento_Por_Referencia, Multicaixa, Transferencia_Bancaria, Pontos, Isento, Carteira_Digital
    }

    public enum EstadoTransacao {
        Solicitada, Recusada, Saldo_Insuficiente, Executada, Em_Validacao, Extornada
    }

    public enum TipoOperacao {
        Solicitada, Recusada, Saldo_Insuficiente, Executada, Em_Validacao, Extornada
    }
}
