package com.sistema.caixa.controller;

import com.sistema.caixa.dto.ClienteDto;
import com.sistema.caixa.dto.CustomerMinDto;
import com.sistema.caixa.services.ClienteService;
import com.sistema.caixa.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;
    @PostMapping
    public ResponseEntity< ClienteDto> insert (@Valid @RequestBody ClienteDto dto){
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> update(@PathVariable  Long id, @Valid @RequestBody ClienteDto dto){
        dto = service.update(id, dto);
        return  ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDto>>findAll(Pageable pageable){
        Page<ClienteDto>dto = service.findAll(pageable);
        return  ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id){
        ClienteDto prod  = service.findById(id);
        return ResponseEntity.ok(prod);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CustomerMinDto>> findByName(@RequestParam String name) {
        List<CustomerMinDto> result = service.findByMin(name);
        return ResponseEntity.ok(result);
    }
}
