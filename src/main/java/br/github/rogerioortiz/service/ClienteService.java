package br.github.rogerioortiz.service;

import br.github.rogerioortiz.model.Cliente;
import br.github.rogerioortiz.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	private ClienteRepository repository;

	public ClienteService( ClienteRepository repository ){
		this.repository = repository;
	}

	public void salvarCliente(Cliente cliente){
		validarCliente(cliente);
		this.repository.persistir(cliente);
	}

	public void validarCliente(Cliente cliente){
		//aplica validações
	}
}
