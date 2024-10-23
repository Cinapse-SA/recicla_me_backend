package ao.cinapse.recicla_me.controllers.carteira;

import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.CarteiraDTO;
import ao.cinapse.recicla_me.models.Carteira;
import ao.cinapse.recicla_me.services.implementacao.CarteiraServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/carteira")
public class CarteiraController extends BaseController<ResponseBody, CarteiraDTO, Carteira, UUID, CarteiraServiceImpl>
{
    @PostMapping("/gerar_carteira")
    public ResponseEntity<ResponseBody> gerarCarteira()
    {
        try {
            Carteira carteira = this.getService().criarParaUsuarioLogado();
            return ok("Carteira criada com sucesso.", CarteiraDTO.builder().build().parse(carteira) );
        }
        catch (Exception e) {
            return badRequest(e.getMessage(), new ArrayList<>() );
        }
    }

    @GetMapping("/minha_carteira")
    public ResponseEntity<ResponseBody> getMinhaCarteira()
    {
        try {
            Carteira carteira = this.getService().getMinhaCarteira();
            return ok("Carteira encontrada com sucesso.", CarteiraDTO.builder().build().parse(carteira) );
        }
        catch (Exception e) {
            return badRequest("Não foi possível encontrar a carteira, "+e.getMessage(), new ArrayList<>() );
        }
    }
}
