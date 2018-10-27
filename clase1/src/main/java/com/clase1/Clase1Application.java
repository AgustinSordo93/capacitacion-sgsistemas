package com.clase1;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class Clase1Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase1Application.class, args);
	}

//	@Bean
//	public CorsConfigurationSource cosrConfigurationSource() {
//		final CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Collections.singletonList("*"));
//		configuration.setAllowedMethods(Collections.singletonList("*"));
//		configuration.setAllowedHeaders(Collections.singletonList("*"));
//		configuration.setAllowCredentials(true);
//		
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		
//		return source;
//	}
}
