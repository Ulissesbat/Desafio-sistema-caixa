package com.sistema.caixa.dto;

import com.sistema.caixa.entities.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;
@Getter
public class UsuarioDtoMe {


    private Long id;
    private String nome;
    private String cpf;
    private String email;

    private List<String> roles = new ArrayList<>();

    public UsuarioDtoMe(Usuario entity){
        id = entity.getId();
        nome = entity.getNome();
        cpf = entity.getCpf();
        email = entity.getEmail();

        for (GrantedAuthority role : entity.getRoles()){
            roles.add(role.getAuthority());
        }
    }

}
