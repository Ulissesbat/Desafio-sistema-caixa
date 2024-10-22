package com.sistema.caixa.dto;

import com.sistema.caixa.entities.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public record UsuarioDto(Long id,
                         @NotBlank(message = "O nome não pode estar em branco.")
                         @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres.")
                         String nome,

                         @NotBlank(message = "O CPF não pode estar em branco.")
                         @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos.")
                         String cpf,

                         @NotBlank(message = "O e-mail não pode estar em branco.")
                         @Email(message = "E-mail deve ser válido.")
                         String email,
                         @NotBlank(message = "A senha é obrigatória")
                         @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
                         String passaword)

{

    public UsuarioDto(Usuario entity){

        this(entity.getId(), entity.getNome(), entity.getCpf(), entity.getEmail(), entity.getPassword());
    }
}
