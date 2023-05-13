package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="grupo") // dado a que se confunde la funcion de esta entidad se cambio el nombre de la tabla a grupo.
public class Curso {
	@Id //lo toma como llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //lo utiliza como autoincrement
	private int crs_id;
	private String crs_nombre;
	
	public int getCrs_id() {
		return crs_id;
	}
	public void setCrs_id(int crs_id) {
		this.crs_id = crs_id;
	}
	public String getCrs_nombre() {
		return crs_nombre;
	}
	public void setCrs_nombre(String crs_nombre) {
		this.crs_nombre = crs_nombre;
	}
	
	

}
