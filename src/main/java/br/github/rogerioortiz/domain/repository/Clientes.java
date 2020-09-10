package br.github.rogerioortiz.domain.repository;

import br.github.rogerioortiz.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "select c from Cliente c where c.nome like :nome")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query("delete fomr Cliente c where c.nome = :nome")
    @Modifying
    void deleteByNome(@Param("nome") String nome);

    boolean existsByNome(String nome);
}
