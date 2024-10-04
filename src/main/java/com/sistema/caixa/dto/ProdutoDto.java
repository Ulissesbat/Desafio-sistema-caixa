package com.sistema.caixa.dto;

import com.sistema.caixa.entities.Produto;

import java.math.BigDecimal;

public record ProdutoDto(Long id, String nome,  BigDecimal preco,  int quantidadeEstoque) {

    public ProdutoDto(Produto entity){
        this(entity.getId(), entity.getNome(), entity.getPreco(), entity.getQuantidadeEstoque());
    }
}
