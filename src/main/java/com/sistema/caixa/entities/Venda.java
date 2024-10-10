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

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true) // Uma venda tem muitos itens
    private List<ItemVenda> itens;

    private LocalDateTime dataHora;

    private BigDecimal valorTotal;

    public BigDecimal calculoTotalDaVenda(){
        BigDecimal total = BigDecimal.ZERO;
        for( ItemVenda item : itens){
            total = total.add(item.calcularSubTotal());
        }
        return total;

    }

}
