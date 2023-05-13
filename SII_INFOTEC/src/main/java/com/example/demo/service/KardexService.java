package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.Mensajes;
import com.example.demo.dto.MatriculaKardexMateria;
import com.example.demo.entity.Kardex;
import com.example.demo.entity.Materia;
import com.example.demo.repository.KardexRepository;
import com.example.demo.repository.MateriaRepository;
import com.example.demo.repository.MatriculaRepository;

@Service
public class KardexService {
	private KardexRepository kardexrepo;
	private MatriculaRepository matricularepo;
	private MateriaRepository materiarepo;
	public KardexService(KardexRepository kardexrepo, MatriculaRepository matricularepo,MateriaRepository materiarepo) {
		this.kardexrepo = kardexrepo;
		this.matricularepo = matricularepo;
		this.materiarepo = materiarepo;
	}
	
	
	//obtener todas la calificaciones
	public List<Kardex> obtenercalificaciones(){
		return this.kardexrepo.findAll();
	}
	
	public List<MatriculaKardexMateria> obtenertodoswithnamne(int mtrID){
		List<MatriculaKardexMateria> kardexlist = new ArrayList<>();
		
		List<Kardex> kardexlist2=kardexrepo.findByMtrId(mtrID);
		
		for(Kardex k:kardexlist2) {
			Materia materia =materiarepo.findById(k.getMtr_id()).get();
			kardexlist.add(new MatriculaKardexMateria(k.getKrd_id(),materia.getMtr_categoria(),materia.getMtr_nombre(),k.getKrd_calificacion()));
		}
		return kardexlist;
		
	}
	
	//Obtener calificaciones de un alumnos
	
	public List<Kardex> obtenercalificacionesbyid(int mtrID){
		try {
			return kardexrepo.findByMtrId(mtrID);
		}catch(NoSuchElementException e) {
			return null;
		}
	}
	public Kardex obtenercali(int id) {
		try {
			return this.kardexrepo.findById(id).get();
		}catch(NoSuchElementException e) {
			return null;
		}
	}
	//insertar calificacion 
	public Mensajes InsertarKardex(Kardex kardex) {
				if(kardex.getKrd_calificacion() <0 || kardex.getKrd_calificacion()>100) {
					return new Mensajes(false, "No se puedo registrar la califacion por es menor a 0 o mayor a 100");
				}
				boolean matricula=matricularepo.existsById(kardex.getMtc_id()); //con el metodo exist, nos retorna un boolean si existe esa matricula
				if(matricula) {
					boolean materia=materiarepo.existsById(kardex.getMtr_id());
						if(materia) {
							List <Kardex> kardexlist = this.kardexrepo.findAll();
							boolean estado=false;
							for(Kardex k:kardexlist) {
								if(k.getMtc_id()==kardex.getMtc_id() && k.getMtr_id()==kardex.getMtr_id()) {
									estado=true;//si ya existe un id de matricula con un id de materia
								}
							}
							if(!estado) { // si el estado es false
								this.kardexrepo.save(kardex);
								return new Mensajes(estado,"Califcacion registrada");
							}else {
								return new Mensajes(estado,"Ya existe una calificacion asociada con esa matricula y esa materia");
							}
						}else {
							return new Mensajes(false,"No existe esa  materia");
						}
				}else {
					return new Mensajes(false,"No existe ese numero de matricula");
				}
				
				 
			 }
	
	// modificar calificacion
	public Mensajes modificarcalifcacion(int id, int califcacion) {
		try {
			Kardex kardex= this.kardexrepo.findById(id).get();
			if(califcacion <0 || califcacion>100) {
				return new Mensajes(false,"La calificacion no puede ser menor que 0 o mayor que 100");
			}else {
				kardex.setKrd_calificacion(califcacion);
				this.kardexrepo.save(kardex);
				return new Mensajes(false,"Calificacion modificada");
			}
		}catch (NoSuchElementException e) {
			return new Mensajes(false,"No se encontro esa califcacion");
	}
	}
	
	//eliminar calificacion
	public Mensajes borrar_calificacion(int id)  {
		try {
	        Kardex kardex= this.kardexrepo.findById(id).get();
	            this.kardexrepo.delete(kardex);
	            return new Mensajes(true, "Califcacion eliminada");
	        
	    } catch (DataIntegrityViolationException e) {
	    	return new Mensajes(false,"No se puede eliminar la calificacion porque tiene evaluaciones asociadas.");
	    } catch (NoSuchElementException e) {
	        return new Mensajes(false, "Calificacion no encontrada");
	    }
		
	}
	
	
	
	
	
}
