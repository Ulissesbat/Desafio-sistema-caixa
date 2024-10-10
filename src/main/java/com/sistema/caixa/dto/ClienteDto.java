package com.sistema.caixa.dto;

import com.sistema.caixa.entities.Cliente;
import com.sistema.caixa.entities.Produto;

import java.math.BigDecimal;

public record ClienteDto(Long id, String nome, String cpf, String email) {

    public ClienteDto(Cliente entity){

        this(entity.getId(), entity.getNome(), entity.getCpf(), entity.getEmail());
    }
}
