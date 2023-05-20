package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cv")
public class CV {
	@Id //lo toma como llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //lo utiliza como autoincrement
	private int cv_id;
	private String cv_nombre_archivo;
	private String cv_url;
	private int usr_id;
	
	public int getCv_id() {
		return cv_id;
	}
	public void setCv_id(int cv_id) {
		this.cv_id = cv_id;
	}
	public String getCv_nombre_archivo() {
		return cv_nombre_archivo;
	}
	public void setCv_nombre_archivo(String cv_nombre_archivo) {
		this.cv_nombre_archivo = cv_nombre_archivo;
	}
	public String getCv_url() {
		return cv_url;
	}
	public void setCv_url(String cv_url) {
		this.cv_url = cv_url;
	}
	public int getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}
	 
	    
}
