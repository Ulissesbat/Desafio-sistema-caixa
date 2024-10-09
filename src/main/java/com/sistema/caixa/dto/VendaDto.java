package com.sistema.caixa.dto;

import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.entities.Venda;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VendaDto( Long id,
                        ClienteDto cliente,
                        List<ItemVendaDto> itens,
                        LocalDateTime dataHora,
                        BigDecimal valorTotal) {


    public VendaDto(Venda venda) {
        this(venda.getId(), new ClienteDto(venda.getCliente()),  // Convertendo Cliente para ClienteDto
                venda.getItens().stream().map(ItemVendaDto::new).toList(),  // Convertendo lista de Itens de Venda
                venda.getDataHora(),
                venda.getValorTotal());
    }
}
