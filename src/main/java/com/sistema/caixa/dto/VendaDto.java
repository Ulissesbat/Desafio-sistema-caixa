package com.sistema.caixa.dto;

import com.sistema.caixa.entities.ItemVenda;
import com.sistema.caixa.entities.Venda;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public record VendaDto(Long id, UsuarioMinDto cliente, List<ItemVendaDto> itens, Instant dataHora, BigDecimal valorTotal) {


    public VendaDto(Venda venda) {
        this(venda.getId(), new UsuarioMinDto(venda.getCliente()),  // Convertendo Usuario para UsuarioDto
                venda.getItens().stream().map(ItemVendaDto::new).toList(),  // Convertendo lista de Itens de Venda
                venda.getDataHora(),
                venda.getValorTotal());
    }
}
