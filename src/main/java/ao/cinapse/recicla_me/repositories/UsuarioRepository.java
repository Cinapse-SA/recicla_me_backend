/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.Usuario;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivandro.sousa
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>
{
    public Optional findByUsername(String username);

    public Optional<Usuario> findByEmail(String email);

    public Optional<Usuario> findByTelefone(String telefone);
}
