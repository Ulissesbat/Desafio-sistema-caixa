package com.sistema.caixa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_item_vendas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class IntemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private int quantidade;

    private BigDecimal precoUnitario;

    private BigDecimal subTotal;

    public BigDecimal calcularSubTotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
