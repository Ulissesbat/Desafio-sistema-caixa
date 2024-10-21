package com.sistema.caixa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "tb_usuario_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role){
        roles.add(role);
    }
    public boolean hasRole(String roleNome){
        for (Role role : roles){
            if (role.getAuthority().equals(roleNome)){
                return true;
            }
        }
        return false;
    }



}