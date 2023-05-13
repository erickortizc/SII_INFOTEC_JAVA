package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {
	@Id //lo toma como llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //lo utiliza como autoincrement
	private int mtr_id;
	private String mtr_nombre;
	private String  mtr_categoria;
	
	public int getMtr_id() {
		return mtr_id;
	}
	public void setMtr_id(int mtr_id) {
		this.mtr_id = mtr_id;
	}
	public String getMtr_nombre() {
		return mtr_nombre;
	}
	public void setMtr_nombre(String mtr_nombre) {
		this.mtr_nombre = mtr_nombre;
	}
	public String getMtr_categoria() {
		return mtr_categoria;
	}
	public void setMtr_categoria(String mtr_categoria) {
		this.mtr_categoria = mtr_categoria;
	}
	
	
}
