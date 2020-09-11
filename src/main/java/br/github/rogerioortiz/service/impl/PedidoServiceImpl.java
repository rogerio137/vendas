package br.github.rogerioortiz.service.impl;


import br.github.rogerioortiz.domain.repository.Pedidos;
import br.github.rogerioortiz.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
