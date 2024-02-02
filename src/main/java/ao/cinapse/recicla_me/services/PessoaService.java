/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ao.cinapse.recicla_me.services;

import ao.cinapse.recicla_me.models.Pessoa;
import java.util.Optional;

/**
 *
 * @author ivandro.sousa
 */
public interface PessoaService {
    
    public Optional<Pessoa> findByNif( String nif ); 
}
