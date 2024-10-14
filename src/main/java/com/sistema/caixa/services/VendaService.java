package com.sistema.caixa.services;

import com.sistema.caixa.dto.ItemVendaDto;
import com.sistema.caixa.dto.VendaDto;
import com.sistema.caixa.entities.Cliente;
import com.sistema.caixa.entities.ItemVenda;
import com.sistema.caixa.entities.Produto;
import com.sistema.caixa.entities.Venda;
import com.sistema.caixa.repositories.ClienteRepository;
import com.sistema.caixa.repositories.ProdutoRepository;
import com.sistema.caixa.repositories.VendaRepository;
import com.sistema.caixa.services.exception.BusinessException;
import com.sistema.caixa.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public VendaDto insert(VendaDto dto) {
        Venda entity = new Venda();

        // Atribuindo os dados básicos da venda
        Cliente cliente = clienteRepository.findById(dto.cliente().id())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado: " + dto.cliente().id()));

        entity.setCliente(cliente);

        // Iterar pelos itens da venda
        List<ItemVenda> itensVenda = new ArrayList<>();

        for (ItemVendaDto itemDto : dto.itens()) {
            Produto produto = produtoRepository.findById(itemDto.produtoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado: " + itemDto.produtoId()));

            // Verificar se há estoque suficiente
            if (produto.getQuantidadeEstoque() < itemDto.quantidade()) {
                throw new BusinessException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            // Reduzir o estoque do produto
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - itemDto.quantidade());
            produtoRepository.save(produto);

            // Criar o item da venda
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProduto(produto);
            itemVenda.setQuantidade(itemDto.quantidade());
            itemVenda.setPrecoUnitario(itemDto.precoUnitario());
            itemVenda.setSubTotal(itemVenda.calcularSubTotal());  // Calcular o subtotal
            itemVenda.setVenda(entity);  // Associa o ItemVenda à Venda
            itensVenda.add(itemVenda);

        }

        // Definir os itens e valor total da venda
        entity.setItens(itensVenda);

        entity.setDataHora(dto.dataHora());

        entity.setValorTotal(entity.calculoTotalDaVenda());

        // Salvar a venda
        entity = vendaRepository.save(entity);

        return new VendaDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<VendaDto>findAll(Pageable pageable){
        Page<Venda>result = vendaRepository.findAll(pageable);
        return result.map(VendaDto::new);
    }
    @Transactional(readOnly = true)
    public VendaDto findById(Long id){
        Venda venda = vendaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
        return new VendaDto(venda);
    }
}
