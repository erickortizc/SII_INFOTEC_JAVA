package com.example.demo.dto;

public class MatriculasWithName {
	private int matriculas;
	private String nombrewithmatriculas;
	
	public int getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(int matriculas) {
		this.matriculas = matriculas;
	}
	public String getNombrewithmatriculas() {
		return nombrewithmatriculas;
	}
	public void setNombrewithmatriculas(String nombrewithmatriculas) {
		this.nombrewithmatriculas = nombrewithmatriculas;
	}
	
	public MatriculasWithName(int matriculas, String nombre) {
		this.matriculas = matriculas;
		this.nombrewithmatriculas = nombre;
	}
	
}
