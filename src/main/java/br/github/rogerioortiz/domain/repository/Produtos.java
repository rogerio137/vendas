package br.github.rogerioortiz.domain.repository;

import br.github.rogerioortiz.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
