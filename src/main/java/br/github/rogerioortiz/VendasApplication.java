package br.github.rogerioortiz;

import br.github.rogerioortiz.domain.entity.Cliente;
import br.github.rogerioortiz.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication

public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){
		return args -> {
			System.out.println("Salvando clientes");
			clientes.save(new Cliente("Dougllas"));
			clientes.save(new Cliente("Outro Cliente"));

			boolean existe = clientes.existsByNome("Dougllas");
			System.out.println("eixste um cliente com o nome Douglas? " + existe);

			/*System.out.println("Atualizando clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado.");
				clientes.save(c);
			});

			todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando clientes");
			clientes.findByNomeLike("Cli").forEach(System.out::println);

            System.out.println("deletando clientes");
            clientes.findAll().forEach(c -> {
                clientes.delete(c);
            });

			todosClientes = clientes.findAll();
			if(todosClientes.isEmpty()){
				System.out.println("Nenhum cliente encontrado.");
			}else{
				todosClientes.forEach(System.out::println);
			}*/
		};
	}



	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}
