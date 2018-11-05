package com.proyecto1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String Nombre;
	private String Direccion;
	private String Rubro;
	
	public Proveedor(Long id, String Nombre, String Direccion, String Rubro) {
		super();
		this.id = id;
		this.Nombre = Nombre;
		this.Direccion = Direccion;
		this.Rubro=Rubro;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getRubro() {
		return Rubro;
	}
	public void setRubro(String rubro) {
		Rubro = rubro;
	}
	
}
