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
import com.example.demo.entity.Materia;
import com.example.demo.service.MateriaService;

@Controller
public class MateriaController {
	@Autowired
	private MateriaService materiaservice;
	
	//Obtener todas las materias
	@GetMapping("/api/administrador/materia/obtenermaterias")
	public ResponseEntity<?> obtenermaterias(){
		return new ResponseEntity<>((this.materiaservice.obtenertodos()),HttpStatus.OK);
	}
	@GetMapping("/api/administrador/materia/obtenermateria/{id}")
	public ResponseEntity<?> obtenermateriabyid(@PathVariable("id") int  id){
		Materia materia =this.materiaservice.obtenerbyid(id);
			if(materia!=null) {
				return new ResponseEntity<>(materia,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new Mensajes(false,"Materia no econtrada"),HttpStatus.OK);
			}
			
		
		
	}
	//obetener materia por id
	
	@PostMapping("/api/administrador/materia/insertarmateria" )
	public ResponseEntity<?> insertarMateria(@RequestBody Materia materia) {
	    return new ResponseEntity<>(this.materiaservice.InsertarUsuario(materia),HttpStatus.OK); // Retorna una respuesta de éxito con código de estado HTTP 200
	}
	
	@PutMapping("/api/administrador/materia/modificarmateria/{id}")
	  public ResponseEntity<?> actualizarMateria(@PathVariable("id") int  id, @RequestBody Materia usuarioActualizado) {
	    return ResponseEntity.ok(materiaservice.actualizarmateria(id, usuarioActualizado));
	  }
	@DeleteMapping("/api/administrador/materia/borrarmateria/{id}")
	public ResponseEntity<?> borrarMateria(@PathVariable("id") int  id) {
		return new ResponseEntity<>(this.materiaservice.borrar_materia(id),HttpStatus.OK);
	  }
	
}
