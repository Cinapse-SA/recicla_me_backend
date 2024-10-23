package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Carteira;
import ao.cinapse.recicla_me.models.Pessoa;
import lombok.*;

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
    private Pessoa pessoa;


    @Override
    public Carteira cast(CarteiraDTO dto) {
        return null;
    }

    @Override
    public CarteiraDTO parse(Carteira entity) {
        return null;
    }

    @Override
    public Carteira cast() {
        return null;
    }
}
