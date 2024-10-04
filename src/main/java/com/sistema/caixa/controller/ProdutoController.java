package com.sistema.caixa.controller;

import com.sistema.caixa.dto.ProdutoDto;
import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.services.ProdutoService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
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
}
