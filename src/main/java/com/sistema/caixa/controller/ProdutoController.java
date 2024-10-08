package com.sistema.caixa.controller;

import com.sistema.caixa.dto.ProdutoDto;
import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.services.ProdutoService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;
    @PostMapping
    public ResponseEntity< ProdutoDto> insert (@RequestBody ProdutoDto dto){
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDto> update(@PathVariable  Long id, @RequestBody ProdutoDto dto){
        dto = service.update(id, dto);
        return  ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDto>>findAll(Pageable pageable){
        Page<ProdutoDto>dto = service.findAll(pageable);
        return  ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDto> findById(@PathVariable Long id){
        ProdutoDto prod  = service.findById(id);
        return ResponseEntity.ok(prod);
    }
}
