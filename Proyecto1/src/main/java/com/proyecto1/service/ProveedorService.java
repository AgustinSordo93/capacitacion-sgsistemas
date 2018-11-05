package com.proyecto1.service;

import java.util.List;

import com.clase.exception.ProveedorNotFoundException;
import com.proyecto1.entity.Proveedor;

public interface ProveedorService {

	public List<Proveedor> getAll();
	public Proveedor getById(Long Id) throws ProveedorNotFoundException;
	public Proveedor save(Proveedor proveedor);
	public Proveedor delete(Long id) throws ProveedorNotFoundException;
}
