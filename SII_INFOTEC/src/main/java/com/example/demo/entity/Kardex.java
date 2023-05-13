package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="kardex")
public class Kardex {
		@Id //lo toma como llave primaria
		@GeneratedValue(strategy = GenerationType.IDENTITY) //lo utiliza como autoincrement
		private int krd_id;
		private int krd_calificacion;
		private int mtc_id; //id de la matricula
		private int mtr_id; //id de la materia
		
		
		public int getKrd_id() {
			return krd_id;
		}
		public void setKrd_id(int krd_id) {
			this.krd_id = krd_id;
		}
		public int getKrd_calificacion() {
			return krd_calificacion;
		}
		public void setKrd_calificacion(int krd_calificacion) {
			this.krd_calificacion = krd_calificacion;
		}
		public int getMtc_id() {
			return mtc_id;
		}
		public void setMtc_id(int mtc_id) {
			this.mtc_id = mtc_id;
		}
		public int getMtr_id() {
			return mtr_id;
		}
		public void setMtr_id(int mtr_id) {
			this.mtr_id = mtr_id;
		}
		
		
}
