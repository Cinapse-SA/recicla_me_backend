/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.utils;

/**
 *
 * @author ivandro.sousa
 */
public class Enums
{
    public enum TipoUsuario {
        FORNECEDOR, TRANSPORTADOR
    };

    public enum TipoFornecedor {
        PEQUENO_FORNECEDOR, MEDIO_FORNECEDOR, GRANDE_FORNECEDOR
    };

    public enum TipoMaterial {
        PLASTICO, FERRO, VIDRO, PAPELAO, MADEIRA
    }

    public enum UnidadeMedida {
        Kg, Ton, grama
    }
}
