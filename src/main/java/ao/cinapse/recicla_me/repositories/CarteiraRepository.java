package ao.cinapse.recicla_me.repositories;

import ao.cinapse.recicla_me.models.Carteira;
import ao.cinapse.recicla_me.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, UUID>
{
    Optional<Carteira> findByIdPessoa(Pessoa pessoa);

    Optional<Carteira>  findByNumeroCarteira(String numeroCarteira);
}
