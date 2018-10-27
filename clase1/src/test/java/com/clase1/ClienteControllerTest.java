package com.clase1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.clase1.controller.ClienteController;
import com.clase1.entity.Cliente;

public class ClienteControllerTest {

	private ClienteController clienteController;
	
	@Before
	public void setUp() {
		this.clienteController = new ClienteController();
	}
	
	@Test
	public void test() {
		Cliente cliente = this.clienteController.getById(2L);
		assertNotNull("Se espera encontrar un cliente", cliente);
		assertTrue("Nombre incorrecto", cliente.getNombre().equals("Pablo"));
		assertTrue("Apellido incorrecto", cliente.getApellido().equals("Marmol"));
	}
	
	@Test
	public void testSave() {
		Cliente cliente = new Cliente(6L, "Juan", "Perez");
		this.clienteController.save(cliente);
		Cliente clienteResult = this.clienteController.getById(6L);
		assertNotNull("Se espera encontrar un cliente", cliente);
		assertTrue("Nombre incorrecto", cliente.getNombre().equals("Juan"));
		assertTrue("Apellido incorrecto", cliente.getApellido().equals("Perez"));
	}

}
