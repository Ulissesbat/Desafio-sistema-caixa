package com.sistema.caixa.dto;

import com.sistema.caixa.entities.ItemVenda;

import java.math.BigDecimal;

public record ItemVendaDto(Long id, Long produtoId, String produto, BigDecimal precoUnitario, int quantidade, BigDecimal subTotal) {

    public ItemVendaDto(ItemVenda itemVenda) {
        this(itemVenda.getId(),
                itemVenda.getProduto().getId(),
                itemVenda.getProduto().getNome(),
                itemVenda.getPrecoUnitario(),
                itemVenda.getQuantidade(),
                itemVenda.calcularSubTotal());
    }
}

