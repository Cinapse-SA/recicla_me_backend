package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.TipoPagamentoDTO;
import ao.cinapse.recicla_me.models.TipoPagamento;
import ao.cinapse.recicla_me.services.implementacao.TipoPagamentoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tipo-pagamento")
public class TipoPagamentoController extends BaseController<ResponseBody,  TipoPagamentoDTO, TipoPagamento, UUID, TipoPagamentoServiceImpl>
{

}
