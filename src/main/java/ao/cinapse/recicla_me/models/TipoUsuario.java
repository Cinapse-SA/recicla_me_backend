/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ivandro.sousa
 */
@Getter
@Setter
@ToString
@Entity
public class TipoUsuario implements Serializable
{ 
    @Id
    @GeneratedValue
    private UUID idTipoUsuario;
    
    @Column( nullable = false, name = "denominacao")
    private String denominacao;
    
    @Column( nullable = false, name = "codigo")
    private String codigo;

    public TipoUsuario()
    {
    }
    
    @Builder
    public TipoUsuario(UUID idTipoUsuario, String denominacao, String codigo)
    {
        this.idTipoUsuario = idTipoUsuario;
        this.denominacao = denominacao;
        this.codigo = codigo;
    }
}
