package com.clase1.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clase1.entity.Cliente;
import com.clase1.exception.ClienteNotFoundException;
import com.clase1.service.ClienteService;
import com.clase1.types.GenericMessage;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> getAll() {
		return this.clienteService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		
		ResponseEntity<?> response = null;
		
		try {
			Cliente cliente = this.clienteService.getById(id);
			response = ResponseEntity.status(HttpStatus.OK).body(cliente);
		} catch (ClienteNotFoundException cnfe) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericMessage(404, "Cliente inexistente"));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return response;
		
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente) {
		
		ResponseEntity<?> response = null;
		
		try {
			Cliente result = this.clienteService.save(cliente);
			response = ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		
		ResponseEntity<?> response = null;
		
		try {
			Cliente result = this.clienteService.delete(id);
			response = ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return response;
	}
}
