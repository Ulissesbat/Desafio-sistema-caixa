package com.sistema.caixa.dto;

import com.sistema.caixa.entities.Cliente;
import com.sistema.caixa.entities.Produto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;


import java.math.BigDecimal;

public record ClienteDto(Long id,
                         @NotBlank(message = "O nome não pode estar em branco.")
                         @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres.")
                         String nome,

                         @NotBlank(message = "O CPF não pode estar em branco.")
                         @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos.")
                         String cpf,

                         @NotBlank(message = "O e-mail não pode estar em branco.")
                         @Email(message = "E-mail deve ser válido.")
                         String email) {

    public ClienteDto(Cliente entity){

        this(entity.getId(), entity.getNome(), entity.getCpf(), entity.getEmail());
    }
}
