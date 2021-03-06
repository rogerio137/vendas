package br.github.rogerioortiz;

import br.github.rogerioortiz.domain.entity.Cliente;
import br.github.rogerioortiz.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class VendasApplication {
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}
