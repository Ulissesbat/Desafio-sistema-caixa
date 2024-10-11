package com.sistema.caixa.repositories;

import com.sistema.caixa.entities.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findByQuantidadeEstoqueLessThanEqual(int quantidade, Pageable pageable);

}
