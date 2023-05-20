package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Mensajes;
import com.example.demo.entity.CV;
import com.example.demo.repository.cvRepository;

@Service
public class cvService {
	public cvRepository cvrepo;
	
	public cvService(cvRepository cvrepo) {
		this.cvrepo = cvrepo;
	}
	
	public CV guardarcv(CV cv) {
		List<CV> allcvs = this.cvrepo.findAll();
		boolean estado=false;
		for(CV c:allcvs) {
			if(cv.getUsr_id()==c.getUsr_id()) {
				estado=true;
			}
		}
		if(!estado) {
			return this.cvrepo.save(cv);
		}else {
			return null;
		}
		
	}
	public CV modificar_cv(int usr_id) {
		CV cv = buscarbyusr_id(usr_id);
		if(cv!=null) {
			return cv;
		}else {
			return null;
		}
		
	}
	public Mensajes borrarcv (int usr_id) {
		CV cv = buscarbyusr_id(usr_id);
		if(cv!=null) {
			this.cvrepo.delete(cv);
			return new Mensajes(false,"CV ELIMINADO");
		}else {
			return new Mensajes(false,"NO SE HA ENCONTRADO UN CV ASOCIADO A SU USUARIO");
		}
	}
	public CV buscarbyusr_id(int usr_id) {
		try {
			return  this.cvrepo.buscarbyusrid(usr_id);
		}catch (Exception e) {
			return null;
		}
		
	}
}
