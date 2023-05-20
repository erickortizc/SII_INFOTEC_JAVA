package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Mensajes;
import com.example.demo.dto.MatriculaUsuarioCurso;
import com.example.demo.dto.MatriculasWithName;
import com.example.demo.entity.Matricula;
import com.example.demo.service.MatriculaUsuarioCursoService;

@Controller
public class MatriculaUsuarioCursoController {
	@Autowired
	private MatriculaUsuarioCursoService matricuususervice;
	
	@GetMapping("/api/administrador/matricula/obtenermatriculasnombres")
	public ResponseEntity<?> obtenercursos(){
		return new ResponseEntity<>((this.matricuususervice.obtenertodos()),HttpStatus.OK);
	}
	
	@GetMapping("/api/administrador/matricula/matriculaswithname")
	public ResponseEntity<?> obtenerconnombre(){
		return new ResponseEntity<>((this.matricuususervice.matriculaswithname()),HttpStatus.OK);
	}

	@GetMapping("/api/administrador/matriculas/obtenermatriculabyusrid/{id}")
		public ResponseEntity<?> obtenermatriculabyusrid(@PathVariable("id") int  id){
		MatriculaUsuarioCurso matricula = this.matricuususervice.obtenerMatriculaPorUsrId(id);
			if(matricula!=null) {
				return new ResponseEntity<>((matricula),HttpStatus.OK);
			}else {
				return new ResponseEntity<>((new Mensajes(false,"No se encontro niguna matricula")),HttpStatus.OK);
			}
			
		}
	
}	
