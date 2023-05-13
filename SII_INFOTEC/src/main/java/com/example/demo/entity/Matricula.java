package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="matricula")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //lo utiliza como autoincrement
	private int mtc_id;
	private int usr_id;
	private int crs_id;
	
	public int getMtc_id() {
		return mtc_id;
	}
	public void setMtc_id(int mtc_id) {
		this.mtc_id = mtc_id;
	}
	public int getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}
	public int getCrs_id() {
		return crs_id;
	}
	public void setCrs_id(int crs_id) {
		this.crs_id = crs_id;
	}
	
}
