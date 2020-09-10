package br.github.rogerioortiz.domain.repository;

import br.github.rogerioortiz.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
