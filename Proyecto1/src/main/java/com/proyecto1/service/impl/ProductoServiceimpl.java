package com.proyecto1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clase.exception.ProductoNotFoundException;
import com.proyecto1.entity.Producto;
import com.proyecto1.repository.ProductoRepository;
import com.proyecto1.service.ProductoService;

@Service
public class ProductoServiceimpl implements ProductoService{
	
	@Autowired
	private ProductoRepository ProductoRepository;

	@Override
	public List<Producto> getAll() {
		
		return this.ProductoRepository.findAll();
	}

	@Override
	public Producto getById(Long id) throws ProductoNotFoundException {
		Producto producto = null;
		Optional<Producto> result =  this.ProductoRepository.findById(id);
		if(result.isPresent()) {
			producto = result.get();
		}
		return producto;
		
	}

	@Override
	public Producto save(Producto producto) {
		return this.ProductoRepository.save(producto);
	}
	
	@Override
	
	
	public Producto delete(Long id) throws ProductoNotFoundException{
		Producto producto = this.getById(id);
		this.ProductoRepository.delete(producto);
		return producto;
		
	}

}
