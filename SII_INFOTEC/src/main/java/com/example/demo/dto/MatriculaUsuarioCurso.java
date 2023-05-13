package com.example.demo.dto;

public class MatriculaUsuarioCurso {
	private int matricula;
	private String nombre;
	private String curso;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public MatriculaUsuarioCurso(int matricula, String nombre, String curso) {
	this.matricula = matricula;
	this.nombre = nombre;
	this.curso = curso;
	}	
	
	
	
}
