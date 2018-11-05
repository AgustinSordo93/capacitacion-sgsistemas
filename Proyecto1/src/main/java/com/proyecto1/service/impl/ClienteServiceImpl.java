package com.proyecto1.service.impl;
import java.util.*;

import com.clase.exception.ClienteNotFoundException;
import com.proyecto1.entity.Cliente;
import com.proyecto1.repository.ClienteRepository;
import com.proyecto1.service.ClienteService;

import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAll() {
		
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente getById(Long id) throws ClienteNotFoundException {
		Cliente cliente = null;
		Optional<Cliente> result =  this.clienteRepository.findById(id);
		if(result.isPresent()) {
			cliente = result.get();
		}
		return cliente;
		
	}

	@Override
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	@Override
	
	
	public Cliente delete(Long id) throws ClienteNotFoundException{
		Cliente cliente = this.getById(id);
		this.clienteRepository.delete(cliente);
		return cliente;
		
	}
	

}
