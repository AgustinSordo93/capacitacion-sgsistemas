package com.proyecto1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clase.exception.ProveedorNotFoundException;
import com.proyecto1.entity.Proveedor;
import com.proyecto1.repository.ProveedorRepository;
import com.proyecto1.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	
	@Autowired
	private ProveedorRepository ProveedorRepository;

	@Override
	public List<Proveedor> getAll() {
		
		return this.ProveedorRepository.findAll();
	}

	@Override
	public Proveedor getById(Long id) throws ProveedorNotFoundException {
		Proveedor proveedor = null;
		Optional<Proveedor> result =  this.ProveedorRepository.findById(id);
		if(result.isPresent()) {
			proveedor = result.get();
		}
		return proveedor;
		
	}

	@Override
	public Proveedor save(Proveedor proveedor) {
		return this.ProveedorRepository.save(proveedor);
	}
	
	@Override
	
	
	public Proveedor delete(Long id) throws ProveedorNotFoundException{
		Proveedor proveedor = this.getById(id);
		this.ProveedorRepository.delete(proveedor);
		return proveedor;
		
	}

}
