package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
}	
