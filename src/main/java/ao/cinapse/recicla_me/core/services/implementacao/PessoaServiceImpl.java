/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.core.services.implementacao;

import ao.cinapse.recicla_me.core.models.Pessoa;
import ao.cinapse.recicla_me.core.repositories.PessoaRepository;
import ao.cinapse.recicla_me.core.services.interfaces.PessoaService;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivandro.sousa
 */
@Service
public class PessoaServiceImpl extends AbstractService<Pessoa, UUID> implements PessoaService
{
    @Override
    protected PessoaRepository getRepository() {
        return (PessoaRepository) super.getRepository();
    }
    
    @Override
    public Pessoa criar(Pessoa entidade) throws Exception {
        if ( this.findByNif( entidade.getNif()).isPresent() )
            throw new Exception("Este NIF, já está cadastrado.");
        return super.criar(entidade);
    }

    @Override
    public Optional<Pessoa> findByNif(String nif) {
        return this.getRepository().findByNif( nif );
    }
}
