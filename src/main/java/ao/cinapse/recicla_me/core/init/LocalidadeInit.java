package ao.cinapse.recicla_me.core.init;

import ao.cinapse.recicla_me.core.models.Localidade;
import ao.cinapse.recicla_me.core.services.implementacao.LocalidadeServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class LocalidadeInit {

    @Autowired
    private LocalidadeServiceImpl service;

    @PostConstruct
    protected void init() {
        try {
            this.loadProvincias();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadProvincias() throws Exception
    {
        for (Localidade localidade : this.getProvincias() )
        {
            if ( !this.service.codigoExistente(localidade.getDenominacao()) )
                this.service.criar(localidade);
        }
    }

    private Localidade[] getProvincias()
    {
        HashMap<String, Localidade> maps = new HashMap<>();
        return new Localidade[]{
            Localidade.builder().denominacao("Luanda").build(),
            Localidade.builder().denominacao("Benguela").build(),
            Localidade.builder().denominacao("Bié").build(),
        };
    }


}
