package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vw_inicio_sesion")
public class Login {
	@Id
	String nombre_completo;
	String correo;
	String usuario;
	String contrasena;
	String telefono;
	String direccion;
	String ruta_imagen;
	String tipo_usuario;
	
	public Login() {}
	public Login(String nombre_completo, String correo, String usuario, String contrasena, String telefono, String direccion, String ruta_imagen,
	String tipo_usuario) {
		this.nombre_completo = nombre_completo;
		this.correo = correo;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ruta_imagen = ruta_imagen;
		this.tipo_usuario = tipo_usuario;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getcorreo() {
		return correo;
	}
	public void setcorreo(String email) {
		this.correo = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRuta_imagen() {
		return ruta_imagen;
	}
	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}
	public String getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

}
