package com.sistema.caixa.repositories;

import com.sistema.caixa.entities.Usuario;
import com.sistema.caixa.projection.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(nativeQuery = true, value = "SELECT nome FROM tb_clientes WHERE UPPER(nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
    List<CustomerMinProjection> projection(String nome);



}
