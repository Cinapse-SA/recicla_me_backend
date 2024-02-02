/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Pessoa
{
    @Id
    @GeneratedValue
    private UUID idPessoa;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "nif", nullable = false)
    private String nif;      
}
