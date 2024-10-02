package com.sistema.caixa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_vendas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany // Uma venda tem muitos itens
    @JoinColumn(name = "venda_id")
    private List<IntemVenda> itens;

    private LocalDateTime dataHora;

    private BigDecimal valorTotal;

    public BigDecimal calculoTotalDaVenda(){
        BigDecimal total = BigDecimal.ZERO;
        for( IntemVenda item : itens){
            total = total.add(item.calcularSubTotal());
        }
        return total;

    }

}
