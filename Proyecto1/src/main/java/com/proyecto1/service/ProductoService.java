package com.proyecto1.service;

import java.util.List;

import com.clase.exception.ProductoNotFoundException;
import com.proyecto1.entity.Producto;

public interface ProductoService {
	
	public List<Producto> getAll();
	public Producto getById(Long Id) throws ProductoNotFoundException;
	public Producto save(Producto producto);
	public Producto delete(Long id) throws ProductoNotFoundException;

}
