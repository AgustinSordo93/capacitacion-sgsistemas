package com.clase1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clase1.entity.Cliente;
import com.clase1.exception.ClienteNotFoundException;
import com.clase1.repository.ClienteRepository;
import com.clase1.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
		
	@Override
	public List<Cliente> getAll() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente getById(Long id) throws ClienteNotFoundException {
		Cliente cliente = null;
		Optional<Cliente> result = this.clienteRepository.findById(id);
		if (result.isPresent()) {
			cliente = result.get();
		}
		return cliente;
	}

	@Override
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente delete(Long id) throws ClienteNotFoundException {
		Cliente cliente = this.getById(id);
		this.clienteRepository.delete(cliente);
		return cliente;
	}

}
