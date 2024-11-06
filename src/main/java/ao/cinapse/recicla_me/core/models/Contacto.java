/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.core.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@Entity(name = "contacto")
public class Contacto implements Serializable
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


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Column(nullable = true)
    private LocalDateTime deletedAt;


    @PrePersist
    public void init() {
        if ( this.createdAt == null )
            this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
