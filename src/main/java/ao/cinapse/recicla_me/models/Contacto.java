/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
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
public class Contacto
{
    @Id
    @GeneratedValue
    private UUID idContacto;
    private String contacto;
    private String tipo;
    private boolean ePrimario;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "idPessoa", nullable = false)
    private Pessoa idPessoa;
}
