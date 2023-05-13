package com.example.demo.dto;

public class MatriculaKardexMateria {
		private int calificacion_id;
		private String categoria;
		private String nombre;
		private int califcacion;
		
		
		public int getCalificacion_id() {
			return calificacion_id;
		}
		public void setCalificacion_id(int calificacion_id) {
			this.calificacion_id = calificacion_id;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getCalifcacion() {
			return califcacion;
		}
		public void setCalifcacion(int califcacion) {
			this.califcacion = califcacion;
		}
		
		public MatriculaKardexMateria(int id, String categoria, String nombre, int califcacion) {
			this.calificacion_id = id;
			this.categoria = categoria;
			this.nombre = nombre;
			this.califcacion = califcacion;
		}
		
		
}	
