package com.clase1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.clase1.controller.HelloController;
import com.clase1.types.HelloResponse;

public class HelloControllerTest {

	private HelloController helloController;

	@Before
	public void setup() {
		this.helloController = new HelloController();
	}
	
	@Test
	public void testSinNombre() {
		HelloResponse message = this.helloController.sayHello(null);
		assertTrue("El mensaje no es el esperado", message.getMessage().equals("Hello there"));
	}

	@Test
	public void testConNombre() {
		HelloResponse message = this.helloController.sayHello("Pepito");
		assertTrue("El mensaje no es el esperado", message.getMessage().equals("Hello Pepito"));
	}

}
