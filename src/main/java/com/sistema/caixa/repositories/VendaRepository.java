package com.sistema.caixa.repositories;

import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
