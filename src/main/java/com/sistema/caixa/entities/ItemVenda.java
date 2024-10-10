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
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private int quantidade;

    private BigDecimal precoUnitario;

    private BigDecimal subTotal;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    public BigDecimal calcularSubTotal() {

        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

}
