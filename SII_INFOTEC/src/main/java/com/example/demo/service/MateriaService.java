package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.Mensajes;
import com.example.demo.entity.Materia;
import com.example.demo.repository.MateriaRepository;

@Service
public class MateriaService {
	private MateriaRepository materiarepo;
	
	 public MateriaService(MateriaRepository materiarepo) {
		 this.materiarepo = materiarepo;
	}
	
	//obtener todas las materias
	public List<Materia> obtenertodos() {
		return this.materiarepo.findAll();
	}
	//obtener materia por id
		public Materia obtenerbyid(Integer id) {
			try {
				Materia materia= this.materiarepo.findById(id).get();
				if(materia!=null) {
						return materia;
				}else {
						return null;
				}
			} catch (NoSuchElementException e) {
				return null;
			}
			
			
		}
	
	//insertar materia
	
	public Mensajes InsertarUsuario(Materia materia) {
		List <Materia> lista = this.materiarepo.findAll();
		boolean estado=false;
		for(Materia m:lista) {
			if(m.getMtr_nombre().equals(materia.getMtr_nombre())) {
				estado=true;
			}
		}
		if(!estado) {
			this.materiarepo.save(materia);
			return new Mensajes(estado,"Materia registrada");
		}else {
			return new Mensajes(estado,"Ya existe un nombre con esa materia");
		}
		 
	 }
	//modificar matera
	public Mensajes actualizarmateria(int id, Materia materia) {
		Materia materia2= obtenerbyid(id);
		try {
			if(materia2!=null) { //lo encontro
				
				List <Materia> lista = this.materiarepo.findAll();
				boolean estado=false;
				for(Materia m:lista) {
					if(m.getMtr_nombre().equals(materia.getMtr_nombre())) {
						estado=true;
					}
				}
				if(!estado) {
					materia2.setMtr_nombre(materia.getMtr_nombre());
					materia2.setMtr_categoria(materia.getMtr_categoria());
					
					this.materiarepo.save(materia2);
					return new Mensajes(estado,"Materia modificada");
				}else {
					return new Mensajes(estado,"Ya existe un nombre con esa materia");
				}
				
				
			}else {
				return new Mensajes(false,"Error, no se encontro esa materia");
			}
		}catch (NoSuchElementException e) {
			return new Mensajes(false,"Error, no se encontro esa materia");
		}
	}
	
	public Mensajes borrar_materia(int id) {
		try {
			Materia materia= obtenerbyid(id);
			if(materia!=null) {
				this.materiarepo.delete(materia);
				return new Mensajes(true,"Materia eliminada");
			}else {
				return new Mensajes(false,"Materia no encontrada");
			}
		}catch(NoSuchElementException e) {
			return new Mensajes(false,"Materia no encontrada");
		}
	}
}
