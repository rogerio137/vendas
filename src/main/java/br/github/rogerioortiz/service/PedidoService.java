package br.github.rogerioortiz.service;

import br.github.rogerioortiz.domain.entity.Pedido;
import br.github.rogerioortiz.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);
}
