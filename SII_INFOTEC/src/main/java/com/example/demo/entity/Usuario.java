package com.example.demo.entity;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="usuario")

public class Usuario {
	public Usuario() {
		
	}
	
	
	public Usuario(Integer id, String nombre, String apellido_paterno, String apellido_materno, String email, String nombre_usuario,
			String contrasena, String telefono,  String estado, String municipio, String codigo_postal, 
			String calle, String numero_casa, String  ruta, Integer rol_id, boolean usr_activo) {
		this.id =id;
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.email = email;
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.estado = estado;
		this.municipio = municipio;
		this.codigo_postal = codigo_postal;
		this.calle = calle;
		this.numero_casa = numero_casa;
		this.ruta = ruta;
		this.rol_id = rol_id;
		this.usr_activo = usr_activo;
	}
	public Usuario(Optional<Usuario> optional, HttpStatus ok) {
		// TODO Auto-generated constructor stub
	}
	@Id //lo toma como llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //lo utiliza como autoincrement
	@Column(name="usr_id") // 
	private Integer id;
	@Column(name="usr_nombre") // 
	private String nombre;
	
	@Column(name="usr_apellido_paterno") // 
	private String apellido_paterno;
	
	@Column(name="usr_apellido_materno") // 
	private String apellido_materno;
	
	@Column(name="usr_email") // 
	private String email;
	
	@Column(name="usr_username") // 
	private String nombre_usuario;
	
	@Column(name="usr_password") // 
	private String contrasena;
	
	@Column(name="usr_telefono") // 
	private String telefono;
	
	@Column(name="usr_estado") // 
	private String estado;
	
	@Column(name="usr_municipio") // 
	private String municipio;
	
	@Column(name="usr_codigo_postal") // 
	private String codigo_postal;
	
	@Column(name="usr_calle") // 
	private String calle;
	
	@Column(name="usr_numero_casa") // 
	private String numero_casa;
	
	@Column(name="usr_ruta") // 
	private String ruta;
	
	@Column(name="rol_id") // 
	private Integer rol_id;
	
	@Column(name="usr_activo") // 
	private boolean usr_activo;
	
	public boolean isUsr_activo() {
		return usr_activo;
	}


	public void setUsr_activo(boolean usr_activo) {
		this.usr_activo = usr_activo;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero_casa() {
		return numero_casa;
	}

	public void setNumero_casa(String numero_casa) {
		this.numero_casa = numero_casa;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Integer getRol_id() {
		return rol_id;
	}

	public void setRol_id(Integer rol_id) {
		this.rol_id = rol_id;
	}

	
	
	
	
}
