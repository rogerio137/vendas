package br.github.rogerioortiz.service.impl;


import br.github.rogerioortiz.domain.entity.Cliente;
import br.github.rogerioortiz.domain.entity.ItemPedido;
import br.github.rogerioortiz.domain.entity.Pedido;
import br.github.rogerioortiz.domain.entity.Produto;
import br.github.rogerioortiz.domain.repository.Clientes;
import br.github.rogerioortiz.domain.repository.ItemsPedidos;
import br.github.rogerioortiz.domain.repository.Pedidos;
import br.github.rogerioortiz.domain.repository.Produtos;
import br.github.rogerioortiz.exception.RegraNegocioException;
import br.github.rogerioortiz.rest.dto.ItemPedidoDTO;
import br.github.rogerioortiz.rest.dto.PedidoDTO;
import br.github.rogerioortiz.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos repository;
    private final Clientes clienteRepository;
    private final Produtos produtosRepository;
    private final ItemsPedidos itemsPedidosRepository;

    @Override
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemsPedidos = converterItems(pedido, dto.getItems());
        repository.save(pedido);
        itemsPedidosRepository.saveAll(itemsPedidos);
        pedido.setItens(itemsPedidos);

        return pedido;
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possivel realizar um pedido sem items");
        }

        return items
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegraNegocioException("Código de produto inválido" + idProduto));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());

    }
}
