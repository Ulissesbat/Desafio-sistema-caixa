package com.sistema.caixa.repositories;

import com.sistema.caixa.entities.Cliente;
import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.projection.CustomerMinProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query(nativeQuery = true, value = "SELECT nome FROM tb_clientes WHERE UPPER(nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
    List<CustomerMinProjection> projection(String nome);



}
