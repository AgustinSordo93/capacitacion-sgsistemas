package com.proyecto1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clase.exception.ProveedorNotFoundException;
import com.proyecto1.entity.Proveedor;
import com.proyecto1.service.ProveedorService;
import com.proyecto1.types.GenericMessage;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping
	public List<Proveedor> getAll() {
		return this.proveedorService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id")long id) {
		ResponseEntity<?> response =null;
		try {
			Proveedor proveedor = this.proveedorService.getById(id);
			response = ResponseEntity.status(HttpStatus.OK).body(proveedor);
		}catch (ProveedorNotFoundException cnfe) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericMessage(404, "cliente"));
		}catch (Exception e)	{
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}		
			
		return response;
	}
	@PostMapping
	
	public ResponseEntity<?> save(@RequestBody Proveedor proveedor) {
		
		ResponseEntity<?> response =null;
	
		try {
			Proveedor result = this.proveedorService.save(proveedor);
			response = ResponseEntity.status(HttpStatus.OK).body(result);
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
		return response;
	}
	
	@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable("id")Long id){
	
	ResponseEntity<?> response =null;
	
	try {
		Proveedor result = this.proveedorService.delete(id);
		response = ResponseEntity.status(HttpStatus.OK).body(result);
	}	catch(Exception e){
		response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

	}
	return response;
	
}
	
	
}
