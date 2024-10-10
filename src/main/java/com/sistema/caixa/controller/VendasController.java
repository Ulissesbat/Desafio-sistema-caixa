package com.sistema.caixa.controller;

import com.sistema.caixa.dto.ClienteDto;
import com.sistema.caixa.dto.VendaDto;
import com.sistema.caixa.services.ClienteService;
import com.sistema.caixa.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("venda")
public class VendasController {
    @Autowired
    private VendaService service;
    @PostMapping
    public ResponseEntity<VendaDto> insert (@RequestBody VendaDto dto){
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
