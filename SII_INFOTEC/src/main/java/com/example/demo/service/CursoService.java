package com.example.demo.service;

import com.example.demo.Mensajes;
import com.example.demo.entity.Curso;
import com.example.demo.repository.CursoRepository;


import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
@Service
public class CursoService {
	private CursoRepository cursorepo;
	
	public CursoService(CursoRepository cursorepo) {
		this.cursorepo = cursorepo;
	}
	
	public List<Curso> obtenertodos(){
		return this.cursorepo.findAll(); //obtener todos los cursos registrados en nuestra bd
	}
	//obtener curso por id
	public Curso obtenerbyid(Integer id) {
		try {
			Curso Curso= this.cursorepo.findById(id).get();
			if(Curso!=null) {
					return Curso;
			}else {
					return null;
					}
				} catch (NoSuchElementException e) {
					return null;
				}
				
				
			}
	//insertar curso
		public Mensajes InsertarCurso(Curso curso) {
			List <Curso> lista = this.cursorepo.findAll();
			boolean estado=false;
			for(Curso m:lista) {
				if(m.getCrs_nombre().equals(curso.getCrs_nombre())) {
					estado=true;//si ya existe un nombre cambiamos el estado
				}
			}
			if(!estado) { // si el estado es false
				this.cursorepo.save(curso);
				return new Mensajes(estado,"Curso registrado");
			}else {
				return new Mensajes(estado,"Ya existe un curso con ese nombre");
			}
			 
		 }
		//modificar curso
		public Mensajes actualizarcurso(int id, Curso curso) {
			Curso curso2= obtenerbyid(id);
			try {
				if(curso2!=null) { //lo encontro
					
					List <Curso> lista = this.cursorepo.findAll();
					boolean estado=false;
					for(Curso m:lista) {
						if(m.getCrs_nombre().equals(curso.getCrs_nombre())) {
							estado=true;
						}
					}
					if(!estado) {
						curso2.setCrs_nombre(curso.getCrs_nombre());
						
						
						this.cursorepo.save(curso2);
						return new Mensajes(estado,"Curso modificada");
					}else {
						return new Mensajes(estado,"Ya existe un curso con ese nombre");
					}
					
					
				}else {
					return new Mensajes(false,"Error, no se encontro ese curso");
				}
			}catch (NoSuchElementException e) {
				return new Mensajes(false,"Error, no se encontro ese curso");
			}
			
			
		}
		
		public Mensajes borrar_curso(int id)  {
			try {
		        Curso curso = obtenerbyid(id);
		        if (curso != null) {
		            this.cursorepo.delete(curso);
		            return new Mensajes(true, "Curso eliminado");
		        } else {
		            return new Mensajes(false, "Curso no encontrado");
		        }
		    } catch (DataIntegrityViolationException e) {
		    	return new Mensajes(false,"No se puede eliminar el curso porque tiene matrículas asociadas.");
		    } catch (NoSuchElementException e) {
		        return new Mensajes(false, "Curso no encontrado");
		    }
			
		}
		
}
