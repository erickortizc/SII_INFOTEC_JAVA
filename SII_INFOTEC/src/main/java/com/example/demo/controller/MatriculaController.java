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
import com.example.demo.entity.Matricula;
import com.example.demo.service.MatriculaService;
@Controller
public class MatriculaController {
	@Autowired
	private MatriculaService matriculaservice;
	
	
	//Obtener todas las matriculas
	@GetMapping("/api/administrador/matriculas/obtenermatriculas")
	public ResponseEntity<?> obtenermatriculas(){
		return new ResponseEntity<>((this.matriculaservice.obtenermatriculas()),HttpStatus.OK);
	}
	//Obtener todas las matriculas
	@GetMapping("/api/administrador/matriculas/obtenermatricula/{id}")
	public ResponseEntity<?> obtenermatriculabyid(@PathVariable("id") int  id){
		Matricula matricula = this.matriculaservice.obtenerbyid(id);
		if(matricula!=null) {
			return new ResponseEntity<>((this.matriculaservice.obtenerbyid(id)),HttpStatus.OK);
		}else {
			return new ResponseEntity<>((new Mensajes(false,"No se encontro niguna matricula")),HttpStatus.OK);
		}
		
	}
	
	//insertar matricula
	@PostMapping("/api/administrador/matriculas/insertarmateria" )
	public ResponseEntity<?> insertarMateria(@RequestBody Matricula matricula) {
		   return new ResponseEntity<>(this.matriculaservice.InsertarMatricula(matricula),HttpStatus.OK); // Retorna una respuesta de éxito con código de estado HTTP 200
	}
	
	@PutMapping("/api/administrador/matriculas/modificarmatricula/{id}")
	public ResponseEntity<?> actualizarMateria(@PathVariable("id") int  id, @RequestBody  Matricula matricula) {
	    return ResponseEntity.ok(matriculaservice.actualizarmatricula(id, matricula));
	}
	@DeleteMapping("/api/administrador/matriculas/borrarmateria/{id}")
	public ResponseEntity<?> borrarMateria(@PathVariable("id") int  id) {
		return new ResponseEntity<>(this.matriculaservice.borrar_matricula(id),HttpStatus.OK);
	  }
	//Metodos para los alumnos
	
	
	
}
