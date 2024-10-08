package com.sistema.caixa.services;

import com.sistema.caixa.dto.ClienteDto;
import com.sistema.caixa.dto.ProdutoDto;
import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.repositories.ProdutoRepository;
import com.sistema.caixa.services.exception.DatabaseException;
import com.sistema.caixa.services.exception.ResourceNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete (Long id) {
        if(! repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DatabaseException("falha de integridade");
        }
    }
    @Transactional(readOnly = true)
    public Page<ProdutoDto>findAll(Pageable pageable){
        Page<Produto>result = repository.findAll(pageable);
        return result.map(ProdutoDto::new);
    }

    @Transactional(readOnly = true)
    public ProdutoDto findById(Long id){
        Produto produto = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
        return new ProdutoDto(produto);
    }
}
