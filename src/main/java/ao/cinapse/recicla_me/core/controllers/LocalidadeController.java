package ao.cinapse.recicla_me.core.controllers;

import ao.cinapse.recicla_me.core.controllers.base.BaseController;
import ao.cinapse.recicla_me.core.http.ResponseBody;
import ao.cinapse.recicla_me.core.http.dtos.LocalidadeDTO;
import ao.cinapse.recicla_me.core.models.Localidade;
import ao.cinapse.recicla_me.core.services.implementacao.LocalidadeServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("localidade")
public class LocalidadeController extends BaseController<ResponseBody, LocalidadeDTO, Localidade, UUID, LocalidadeServiceImpl>
{
}
