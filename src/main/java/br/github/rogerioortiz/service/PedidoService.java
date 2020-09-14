package br.github.rogerioortiz.service;

import br.github.rogerioortiz.domain.entity.Pedido;
import br.github.rogerioortiz.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);
}
