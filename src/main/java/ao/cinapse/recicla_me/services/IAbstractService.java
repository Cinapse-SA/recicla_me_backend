package ao.cinapse.recicla_me.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public interface IAbstractService <E, K>
{
    public List<E> findAll();

    public Page<E> findAll(Pageable pageable );
    public Page<E> findAllPaginado( Pageable pageable );
    public E criar( E entidade ) throws Exception ;
    public E editar( K id, E entidade );
    public E eliminar( K id );
}
