package br.github.rogerioortiz.domain.repository;

import br.github.rogerioortiz.domain.entity.Cliente;
import br.github.rogerioortiz.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
