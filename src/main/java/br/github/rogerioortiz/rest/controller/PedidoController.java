package br.github.rogerioortiz.rest.controller;

import br.github.rogerioortiz.domain.entity.Pedido;
import br.github.rogerioortiz.rest.dto.PedidoDTO;
import br.github.rogerioortiz.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save( @RequestBody PedidoDTO dto ){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }
}
