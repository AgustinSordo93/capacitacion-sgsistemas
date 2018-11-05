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

import com.clase.exception.ProductoNotFoundException;
import com.proyecto1.entity.Producto;
import com.proyecto1.service.ProductoService;
import com.proyecto1.types.GenericMessage;

@RestController
@RequestMapping("/productos")

public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public List<Producto> getAll() {
		return this.productoService.getAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id")long id) {
		ResponseEntity<?> response =null;
		try {
			Producto producto = this.productoService.getById(id);
			response = ResponseEntity.status(HttpStatus.OK).body(producto);
		}catch (ProductoNotFoundException cnfe) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericMessage(404, "producto"));
		}catch (Exception e)	{
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}		
			
		return response;
	}
	
	@PostMapping
	
	public ResponseEntity<?> save(@RequestBody Producto producto) {
		
		ResponseEntity<?> response =null;
	
		try {
			Producto result = this.productoService.save(producto);
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
		Producto result = this.productoService.delete(id);
		response = ResponseEntity.status(HttpStatus.OK).body(result);
	}	catch(Exception e){
		response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

	}
	return response;
	
}
	
	
	

}
