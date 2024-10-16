package com.sistema.caixa.repositories;

import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.projection.CustomerMinProjection;
import com.sistema.caixa.projection.ProductMinProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findByQuantidadeEstoqueLessThanEqual(int quantidade, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT nome FROM tb_produtos WHERE UPPER(nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
    List<ProductMinProjection> projection(String nome);

}
