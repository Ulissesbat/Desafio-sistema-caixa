package com.sistema.caixa.controller;

import com.sistema.caixa.dto.UsuarioDto;
import com.sistema.caixa.dto.CustomerMinDto;
import com.sistema.caixa.services.UsuarioService;
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
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    @PostMapping
    public ResponseEntity<UsuarioDto> insert (@Valid @RequestBody UsuarioDto dto){
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable  Long id, @Valid @RequestBody UsuarioDto dto){
        dto = service.update(id, dto);
        return  ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDto>>findAll(Pageable pageable){
        Page<UsuarioDto>dto = service.findAll(pageable);
        return  ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id){
        UsuarioDto prod  = service.findById(id);
        return ResponseEntity.ok(prod);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CustomerMinDto>> findByName(@RequestParam String name) {
        List<CustomerMinDto> result = service.findByMin(name);
        return ResponseEntity.ok(result);
    }
}
