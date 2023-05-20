package com.example.demo.dto;

public class UsuarioKardexCV {
	private int usr_id;
	private String nombre_completo;
	private String nombre_usuario;
	private double promedio;
	private String cv_ruta;
	
	public int getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	public String getCv_ruta() {
		return cv_ruta;
	}
	public void setCv_ruta(String cv_ruta) {
		this.cv_ruta = cv_ruta;
	}
	public UsuarioKardexCV(int usr_id, String nombre_completo, String nombre_usuario, double promedio,
			String cv_ruta) {
		super();
		this.usr_id = usr_id;
		this.nombre_completo = nombre_completo;
		this.nombre_usuario = nombre_usuario;
		this.promedio = promedio;
		this.cv_ruta = cv_ruta;
	}
	
	
}
