package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MatriculaUsuarioCurso;
import com.example.demo.dto.MatriculasWithName;
import com.example.demo.entity.Curso;
import com.example.demo.entity.Matricula;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.UsuarioRepository;

@Service
public class MatriculaUsuarioCursoService {
	
	private MatriculaRepository matricularepo;
	private UsuarioRepository usuariorepo;
	private CursoRepository cursorepo;
	
	public MatriculaUsuarioCursoService(MatriculaRepository matricularepo,UsuarioRepository usuariorepo,CursoRepository cursorepo) {
		this.matricularepo = matricularepo;
		this.usuariorepo = usuariorepo;
		this.cursorepo = cursorepo;
	}
	
	public List<MatriculaUsuarioCurso> obtenertodos(){
		List<MatriculaUsuarioCurso> matriculasusuarios = new ArrayList<>();
		try {
			
			List<Matricula> matriculas = this.matricularepo.findAll();
			
			for(Matricula m:matriculas) {
				Usuario user=this.usuariorepo.findById(m.getUsr_id()).get();
				Curso curso=this.cursorepo.findById(m.getCrs_id()).get();
				String nombre=user.getNombre() + " " + user.getApellido_paterno() +" " +  user.getApellido_materno();
				
				MatriculaUsuarioCurso nuevoobjeto = new MatriculaUsuarioCurso(m.getMtc_id(),nombre,curso.getCrs_nombre());
				matriculasusuarios.add(nuevoobjeto);
			}
			
			return matriculasusuarios;
		}catch (Exception e) {
			return null;
		}
		
	}
	public List<MatriculasWithName> matriculaswithname(){
		
		
		try {
			List<MatriculasWithName> matriculaswithname= new ArrayList<>();
			List<Matricula> matriculas = this.matricularepo.findAll();
			for(Matricula m:matriculas) {
				Usuario user=this.usuariorepo.findById(m.getUsr_id()).get();
				
				String nombre = user.getNombre() + " " + user.getApellido_paterno() +" " +  user.getApellido_materno()+" - "+ m.getMtc_id();
				MatriculasWithName nuevoobjeto = new MatriculasWithName(m.getMtc_id(),nombre);
				
				matriculaswithname.add(nuevoobjeto);
				
			}
			return matriculaswithname;
		}catch (Exception e) {
			return null;
		}
	}
}
