package com.sistema.caixa.services;

import com.sistema.caixa.dto.ProdutoDto;
import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.repositories.ProdutoRepository;
import com.sistema.caixa.services.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;
    @Transactional
    public ProdutoDto insert(ProdutoDto dto){
        Produto entity = new Produto();

        entity.setNome(dto.nome());
        entity.setPreco(dto.preco());
        entity.setQuantidadeEstoque(dto.quantidadeEstoque());

        entity = repository.save(entity);

        return new ProdutoDto(entity);
    }
    @Transactional
    public ProdutoDto update(Long id, ProdutoDto dto) {

        Produto entity = repository.getReferenceById(id);
        entity.setNome(dto.nome());
        entity.setPreco(dto.preco());
        entity.setQuantidadeEstoque(dto.quantidadeEstoque());

        entity = repository.save(entity);

        return new ProdutoDto(entity);
    }
    @Transactional
    public void delete(Long id){

    }
}
