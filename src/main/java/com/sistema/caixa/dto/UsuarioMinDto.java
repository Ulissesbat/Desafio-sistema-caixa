package com.sistema.caixa.dto;

import com.sistema.caixa.entities.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioMinDto(Long id, String nome, String cpf)

{

    public UsuarioMinDto(Usuario entity){

        this(entity.getId(), entity.getNome(), entity.getCpf());
    }
}
