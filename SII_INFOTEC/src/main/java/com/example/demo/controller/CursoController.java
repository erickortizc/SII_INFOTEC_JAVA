package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Mensajes;
import com.example.demo.entity.Curso;
import com.example.demo.service.CursoService;

@Controller
public class CursoController {
	@Autowired
	private CursoService cursoservice; //inyector de dependencias
	
	
	
	@GetMapping("/api/administrador/cursos/obtenercursos")
	public ResponseEntity<?> obtenercursos(){
		return new ResponseEntity<>((this.cursoservice.obtenertodos()),HttpStatus.OK);
	}
	
	@GetMapping("/api/administrador/cursos/obtenercurso/{id}")
	public ResponseEntity<?> obtenercursos(@PathVariable("id") int  id){
		Curso curso =this.cursoservice.obtenerbyid(id);
			if(curso!=null) {
				return new ResponseEntity<>(curso,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new Mensajes(false,"Curso no econtrada"),HttpStatus.OK);
			}
	}
	
	@PostMapping("/api/administrador/cursos/insertarcurso" )
	public ResponseEntity<?> insertarCurso(@RequestBody Curso curso) {
	    return new ResponseEntity<>(this.cursoservice.InsertarCurso(curso),HttpStatus.OK); // Retorna una respuesta de éxito con código de estado HTTP 200
	}
	
	@PutMapping("/api/administrador/cursos/modificarcurso/{id}")
	  public ResponseEntity<?> actualizarCurso(@PathVariable("id") int  id, @RequestBody Curso curso) {
	    return ResponseEntity.ok(cursoservice.actualizarcurso(id, curso));
	  }
	
	@DeleteMapping("/api/administrador/cursos/borrarcurso/{id}")
	public ResponseEntity<?> eliminarcurso(@PathVariable("id") int  id)  {
		return new ResponseEntity<>(this.cursoservice.borrar_curso(id),HttpStatus.OK);
	  }
}
