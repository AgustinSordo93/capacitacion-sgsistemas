package com.clase1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clase1.types.HelloResponse;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public HelloResponse sayHello(
				@RequestParam(name="name", required = false) String name
			) {
		
		HelloResponse response = new HelloResponse();
		
		if (name != null) {
			response.setMessage("Hello " + name);
		} else {
			response.setMessage("Hello there");
		}
		return response;
		
	}
	
	
}
