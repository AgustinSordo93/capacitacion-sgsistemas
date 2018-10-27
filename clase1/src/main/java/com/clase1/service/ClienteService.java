package com.clase1.service;

import java.util.List;

import com.clase1.entity.Cliente;
import com.clase1.exception.ClienteNotFoundException;

public interface ClienteService {

	public List<Cliente> getAll();
	public Cliente getById(Long id) throws ClienteNotFoundException;
	public Cliente save(Cliente cliente);
	public Cliente delete(Long id) throws ClienteNotFoundException;
	
}
