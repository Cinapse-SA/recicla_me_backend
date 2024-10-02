package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.TipoMaterialDTO;
import ao.cinapse.recicla_me.http.dtos.TipoPagamentoDTO;
import ao.cinapse.recicla_me.models.TipoPagamento;
import ao.cinapse.recicla_me.services.implementacao.TipoPagamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tipo-pagamentotipo-pagamento")
public class TipoPagamentoController extends BaseController<ResponseBody,  TipoPagamentoDTO, TipoPagamento, UUID, TipoPagamentoServiceImpl>
{
    @Autowired
    private TipoPagamentoDTO dto;

    @Override
    public ResponseEntity<ResponseBody> listar(Pageable page) {
        return this.ok( "Lista de Tipos de Pagamentosg", this.dto.toListFromEntityList( getService().findAll()) );
    }
}
