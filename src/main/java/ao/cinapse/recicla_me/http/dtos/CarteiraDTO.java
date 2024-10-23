package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Carteira;
import ao.cinapse.recicla_me.models.Pessoa;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarteiraDTO extends AbstractDTO<Carteira, CarteiraDTO>
{
    private UUID id;
    private String numeroCarteira;
    private String displayNumeroCarteira;
    private String numeroConta;
    private String iban;
    private Double saldoDisponivel;
    private Double saldoContabilistico;
    private String moeda;
    private String simboloMoeda;
    private PessoaDTO pessoa;


    @Override
    public Carteira cast(CarteiraDTO dto) {
        Carteira entity = new Carteira();
        entity.setIdCarteira( dto.getId() );
        BeanUtils.copyProperties(dto, entity);
        entity.setIdPessoa( PessoaDTO.builder().build().cast(dto.getPessoa()));
        return entity;
    }

    @Override
    public CarteiraDTO parse(Carteira entity) {
        CarteiraDTO dto = new CarteiraDTO();
        dto.setId( entity.getIdCarteira() );
        BeanUtils.copyProperties(entity, dto);
        dto.setPessoa( PessoaDTO.builder().build().parse(entity.getIdPessoa()));
        return dto;
    }

    @Override
    public Carteira cast() {
        Carteira entity = new Carteira();
        entity.setIdCarteira( this.getId() );
        BeanUtils.copyProperties( this, entity);
        entity.setIdPessoa( PessoaDTO.builder().build().cast(this.getPessoa()));
        return entity;
    }
}
