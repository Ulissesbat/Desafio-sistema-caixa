package com.sistema.caixa.services;

import com.sistema.caixa.dto.ClienteDto;
import com.sistema.caixa.dto.CustomerMinDto;
import com.sistema.caixa.entities.Cliente;
import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.projection.CustomerMinProjection;
import com.sistema.caixa.repositories.ClienteRepository;
import com.sistema.caixa.repositories.ProdutoRepository;
import com.sistema.caixa.services.exception.DatabaseException;
import com.sistema.caixa.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Transactional
    public ClienteDto insert(ClienteDto dto){
        Cliente entity = new Cliente();

        entity.setNome(dto.nome());
        entity.setCpf(dto.cpf());
        entity.setEmail(dto.email());

        entity = repository.save(entity);

        return new ClienteDto(entity);
    }
    @Transactional
    public ClienteDto update(Long id, ClienteDto dto) {

        Cliente entity = repository.getReferenceById(id);
        entity.setNome(dto.nome());
        entity.setCpf(dto.cpf());
        entity.setEmail(dto.email());

        entity = repository.save(entity);

        return new ClienteDto(entity);
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
    public Page<ClienteDto>findAll(Pageable pageable){
        Page<Cliente>result = repository.findAll(pageable);
        return result.map(ClienteDto::new);
    }

    @Transactional(readOnly = true)
    public ClienteDto findById(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
        return new ClienteDto(cliente);
    }

    @Transactional(readOnly = true)
    public List<CustomerMinDto> findByMin(String name) {
        List<CustomerMinProjection> projections = repository.projection(name);
        return projections.stream().map(CustomerMinDto::new).collect(Collectors.toList());
    }
}
