package com.sistema.caixa.dto;

import com.sistema.caixa.entities.Produto;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProdutoDto(Long id,
                         @NotBlank(message = "O nome não pode estar em branco.")
                         @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres.")
                         String nome,
                         @NotNull(message = "O preço do produto não pode ser nulo.")
                         @DecimalMin(value = "0.0", inclusive = false, message = "O preço do produto deve ser maior que zero.")
                         BigDecimal preco,
                         @NotNull(message = "A quantidade em estoque não pode ser nula.")
                         @Min(value = 1, message = "A quantidade em estoque deve ser maior que zero.")
                         int quantidadeEstoque) {

    public ProdutoDto(Produto entity){
        this(entity.getId(), entity.getNome(), entity.getPreco(), entity.getQuantidadeEstoque());
    }
}
