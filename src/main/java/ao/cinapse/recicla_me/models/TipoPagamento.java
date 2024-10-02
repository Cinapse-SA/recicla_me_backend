package ao.cinapse.recicla_me.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "tipo_pagamento")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoPagamento
{
    @Id
    @GeneratedValue
    private UUID idTipoPagamento;

    private String denominacao;
    private String descricao;
    private String codigo;
}
