package ao.cinapse.recicla_me.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "tipo_fornecedor")
public class TipoFornecedor implements Serializable {

    @Id
    @GeneratedValue
    private UUID idTipoFornecedor;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String denominacao;

    @Column(nullable = true)
    private String descricao;

    public TipoFornecedor() {

    }

    @Builder
    public TipoFornecedor(UUID idTipoFornecedor, String codigo, String denominacao, String descricao) {
        this.idTipoFornecedor = idTipoFornecedor;
        this.codigo = codigo;
        this.denominacao = denominacao;
        this.descricao = descricao;
    }
}
