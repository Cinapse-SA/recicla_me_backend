package ao.cinapse.recicla_me.controllers.material;

import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.RecolhaDTO;
import ao.cinapse.recicla_me.models.Recolha;
import ao.cinapse.recicla_me.services.implementacao.RecolhaServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("recolha")
public class RecolhaController extends BaseController<ResponseBody, RecolhaDTO, UUID, Recolha, RecolhaServiceImpl> {
}
