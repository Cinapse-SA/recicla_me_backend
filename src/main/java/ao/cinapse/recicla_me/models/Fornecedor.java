package ao.cinapse.recicla_me.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue
    private UUID idFornecedor;

    private String numeroFornecedor;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPessoa", name = "id_pessoa", nullable = false)
    private Pessoa idPessoa;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idTipoFornecedor", name = "id_tipo_fornecedor", nullable = false)
    private TipoFornecedor idTipoFornecedor;



}
