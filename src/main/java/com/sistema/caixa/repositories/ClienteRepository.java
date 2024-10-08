package com.sistema.caixa.repositories;

import com.sistema.caixa.entities.Cliente;
import com.sistema.caixa.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
