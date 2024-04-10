package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.LocalidadeDTO;
import ao.cinapse.recicla_me.models.Localidade;
import ao.cinapse.recicla_me.services.implementacao.LocalidadeServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("localidade")
public class LocalidadeController extends BaseController<ResponseBody, LocalidadeDTO, Localidade, UUID, LocalidadeServiceImpl>
{
}
