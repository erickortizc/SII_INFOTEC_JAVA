package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.Mensajes;
import com.example.demo.entity.Curso;
import com.example.demo.entity.Matricula;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.UsuarioRepository;

@Service
public class MatriculaService {
	private MatriculaRepository matricularepo;
	private CursoRepository cursorepo;
	private UsuarioRepository usuariorepo;
	
	public MatriculaService(MatriculaRepository matricularepo,CursoRepository cursorepo, UsuarioRepository usuariorepo) {
		this.matricularepo = matricularepo;
		this.cursorepo = cursorepo;
		this.usuariorepo = usuariorepo;
	}
	//obteniendo todas las matricula
	public List<Matricula> obtenermatriculas(){
		return this.matricularepo.findAll();
	}
	
	//obtener matricula por id
	public Matricula obtenerbyid(Integer id) {
		try {
			Matricula materia= this.matricularepo.findById(id).get();
					
			return materia;
					
		} catch (NoSuchElementException e) {
			return null;
		}		
	}
	
	//insertar Matricula
	public Mensajes InsertarMatricula(Matricula matricula) {
			List <Matricula> lista = this.matricularepo.findAll();
			List <Curso> lista2 = this.cursorepo.findAll();
			List <Usuario> lista3 = this.usuariorepo.findAll();
		boolean estado=false;
			for(Matricula m:lista) {
				if(m.getUsr_id()==matricula.getUsr_id()) {
					estado=true;
				}
			}
			
		boolean estado2=true;
			
			for(Curso c:lista2) {
				if(c.getCrs_id()==matricula.getCrs_id()) {
					estado2=false;
				}
			}
			
		boolean estado3=true;
			for(Usuario u:lista3) {
				if(u.getId()==matricula.getUsr_id() && u.getRol_id() == 2) {
					estado3=false;
				}
			}
			
		if(!estado && !estado2 && !estado3) {
			this.matricularepo.save(matricula);
			return new Mensajes(estado,"Matricula registrada");
		}else
		if(estado){
			return new Mensajes(estado,"Ya existe un usuario con materia");
		}else
		if(estado2){
			return new Mensajes(estado,"No existe ese curso");
		}else 
		if(estado3){
			return new Mensajes(estado,"No existe ese usuario ó no pertenece al rol del alumno");
		}else
		{
			return new Mensajes(false,"Ha sucedido un error inesperado");
		}
			 
		}
	
	//modificar matera
		public Mensajes actualizarmatricula(int id, Matricula matricula) {
			Matricula matricula2= obtenerbyid(id);
			try {
					List <Curso> lista2 = this.cursorepo.findAll();
					List <Usuario> lista3 = this.usuariorepo.findAll();
					List <Matricula> lista = this.matricularepo.findAll();
					
					
					boolean estado=false;
					
					
					boolean estado2=true;
					
					for(Curso c:lista2) {
						if(c.getCrs_id()==matricula.getCrs_id()) {
							estado2=false;
						}
					}
					
					boolean estado3=true;
					for(Usuario u:lista3) {
						if(u.getId()==matricula.getUsr_id() && u.getRol_id() == 2) {
							estado3=false;
						}
					}
					if( !estado2 && !estado3) {
						estado=true;
						matricula2.setUsr_id(matricula.getUsr_id());
						matricula2.setCrs_id(matricula.getCrs_id());
						
						this.matricularepo.save(matricula2);
						return new Mensajes(estado,"Matricula modificada");
					}else
					if(estado){
						return new Mensajes(estado,"Ya existe un usuario con materia");
					}else
					if(estado2){
						return new Mensajes(estado,"No existe ese curso");
					}else 
					if(estado3){
						return new Mensajes(estado,"No existe ese usuario ó no pertenece al rol del alumno");
					}else
					{
						return new Mensajes(false,"Ha sucedido un error inesperado");
					}
					
					
				
			}catch (NoSuchElementException e) {
				return new Mensajes(false,"Error, no se encontro esa matricula");
			}
		}
		
		public Mensajes borrar_matricula(int id) {
			try {
				Matricula matricula= obtenerbyid(id);

					this.matricularepo.delete(matricula);
					return new Mensajes(true,"Matricula eliminada");
			
			}catch(NoSuchElementException e) {
				return new Mensajes(false,"Matricula no encontrada");
			}
		}
	//metodos para alumnos
		 public Matricula obtenerMatriculaPorUsrId(int usrId) {
			 try {
				 return matricularepo.findByUsrId(usrId);
			 }catch (NoSuchElementException e) {
				return null;
			}
		        
		    }
		
}
