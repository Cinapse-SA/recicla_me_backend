package ao.cinapse.recicla_me.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "carteira")
public class Carteira implements Serializable
{
    @Id
    @GeneratedValue
    private UUID idCarteira;

    private String numeroCarteira;
    private String displayNumeroCarteira;

    private String numeroConta;
    private String iban;

    private Double saldoDisponivel;
    private Double saldoContabilistico;

    private String moeda;
    private String simboloMoeda;

    @OneToOne
    @JoinColumn(referencedColumnName = "idPessoa", nullable = false)
    private Pessoa idPessoa;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private LocalDateTime deletedAt;

    @PrePersist
    public void init() {
        if ( this.createdAt == null )
            this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
