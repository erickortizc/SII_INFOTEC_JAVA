package com.example.demo;

public class Mensajes {
	private boolean estado;
	private String mensaje;
	
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Mensajes(boolean estado, String mensaje) {
		this.estado = estado;
		this.mensaje = mensaje;
	}
	
}
