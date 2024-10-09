package com.sistema.caixa.dto;

import com.sistema.caixa.entities.IntemVenda;

import java.math.BigDecimal;

public record ItemVendaDto(Long id, String produto, BigDecimal preco, int quantidade) {

    public ItemVendaDto(IntemVenda itemVenda) {
        this(itemVenda.getId(), itemVenda.getProduto().getNome(), itemVenda.getSubTotal(), itemVenda.getQuantidade());
    }
}

