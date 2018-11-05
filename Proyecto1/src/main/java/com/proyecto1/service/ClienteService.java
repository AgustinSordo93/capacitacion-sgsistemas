package com.proyecto1.service;
import com.clase.exception.ClienteNotFoundException;
import com.proyecto1.entity.Cliente;

import java.util.*;
public interface ClienteService {
	
	public List<Cliente> getAll();
	public Cliente getById(Long Id) throws ClienteNotFoundException;
	public Cliente save(Cliente cliente);
	public Cliente delete(Long id) throws ClienteNotFoundException;

}
