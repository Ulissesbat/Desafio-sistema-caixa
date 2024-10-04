package com.sistema.caixa.services;

import com.sistema.caixa.dto.ProdutoDto;
import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.repositories.ProdutoRepository;
import com.sistema.caixa.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public ProdutoDto insert(ProdutoDto dto){
        Produto entity = new Produto();

        entity.setNome(dto.nome());
        entity.setPreco(dto.preco());
        entity.setQuantidadeEstoque(dto.quantidadeEstoque());

        entity = repository.save(entity);

        return new ProdutoDto(entity);
    }

    public ProdutoDto update(Long id, ProdutoDto dto) {

        Produto entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        entity.setNome(dto.nome());
        entity.setPreco(dto.preco());
        entity.setQuantidadeEstoque(dto.quantidadeEstoque());

        entity = repository.save(entity);

        return new ProdutoDto(entity);

    }
}
