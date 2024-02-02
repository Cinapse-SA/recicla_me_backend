package ao.cinapse.recicla_me.http.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.springframework.data.domain.Page;

public abstract class AbstractDTO<E, D> implements Serializable
{
    public abstract E cast(D dto);
    public abstract D parse(E entity);
    
    public abstract E cast();
    
    public List<D> toListFromEntityList( List<E> entities) {
        return entities.stream().map(this::parse).toList();
    }
    
    public HashMap paginar( Page page ) 
    {
        HashMap<String, Object> paginacao = new HashMap();
        
        return paginacao;
    }
}
