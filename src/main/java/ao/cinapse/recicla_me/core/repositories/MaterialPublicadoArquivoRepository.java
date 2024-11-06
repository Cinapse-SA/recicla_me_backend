package ao.cinapse.recicla_me.core.repositories;

import ao.cinapse.recicla_me.core.models.MaterialPublicadoArquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MaterialPublicadoArquivoRepository extends JpaRepository<MaterialPublicadoArquivo, UUID> {
}
