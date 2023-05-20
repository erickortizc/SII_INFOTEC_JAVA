package com.example.demo.dto;

public class KardexwithCategoria {
	private int krd_id;
	private int krd_calificacion;
	private int mtc_id;
	private String mtr_categoria;
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
	public String getMtr_categoria() {
		return mtr_categoria;
	}
	public void setMtr_categoria(String mtr_categoria) {
		this.mtr_categoria = mtr_categoria;
	}
	public KardexwithCategoria(int krd_id, int krd_calificacion, int mtc_id, String mtr_categoria) {
		super();
		this.krd_id = krd_id;
		this.krd_calificacion = krd_calificacion;
		this.mtc_id = mtc_id;
		this.mtr_categoria = mtr_categoria;
	}
	public KardexwithCategoria() {
		
	}
	
	
}	
