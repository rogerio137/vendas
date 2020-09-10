package br.github.rogerioortiz.domain.repository;

import br.github.rogerioortiz.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedidos extends JpaRepository<ItemPedido, Integer> {
}
