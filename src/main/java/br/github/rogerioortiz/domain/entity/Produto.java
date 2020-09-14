package br.github.rogerioortiz.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    @NotEmpty(message = "Campoi descrição é obrigatorio")
    private String descricao;

    @Column(name = "preco_unitario")
    @NotNull(message = "Campo preço é opbrigatório")
    private BigDecimal preco;


}
