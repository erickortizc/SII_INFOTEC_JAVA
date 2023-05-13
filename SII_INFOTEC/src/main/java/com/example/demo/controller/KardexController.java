package com.example.demo.controller;


import java.util.List;

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
import com.example.demo.dto.MatriculaKardexMateria;
import com.example.demo.entity.Kardex;
import com.example.demo.service.KardexService;

@Controller
public class KardexController {
	@Autowired
	private KardexService kardexservice;
	
	//Obtener todas las matriculas
	@GetMapping("/api/administrador/kardex/obtenercalificacion/{id}")
	public ResponseEntity<?> obtenermatriculas(@PathVariable("id") int id){
		if(this.kardexservice.obtenercali(id)!=null) {
			return new ResponseEntity<>((this.kardexservice.obtenercali(id)),HttpStatus.OK);
		}else {
			return new ResponseEntity<>((new Mensajes(false, "Error, no se encontro ninguna califcacion con ese id alumno")),HttpStatus.OK);
		}
			
	}
	//Obtener todas las matriculas
	@GetMapping("/api/administrador/kardex/obtenercalificacioneswithname/{id}")
	public ResponseEntity<?> obtenermatriculaswithname(@PathVariable("id") int mtrId){
		List<MatriculaKardexMateria> kardex = this.kardexservice.obtenertodoswithnamne(mtrId);
		if(!kardex.isEmpty()) { //metodo que retorna un booleano sobre si el objeto no tiene ningun elmentos
			return new ResponseEntity<>((kardex),HttpStatus.OK);
		}else {
			return new ResponseEntity<>((new Mensajes(false, "Error, no se encontro ninguna califcacion asociada a ese alumno")),HttpStatus.OK);
		}
			
	}
	
	@GetMapping("/api/administrador/kardex/obtenercalificaciones/{id}")
	public ResponseEntity<?> obtenercalificacionesbyid(@PathVariable("id") int mtrId){
			List<Kardex> kardex = this.kardexservice.obtenercalificacionesbyid(mtrId);
			if(!kardex.isEmpty()) { //metodo que retorna un booleano sobre si el objeto no tiene ningun elmentos
				return new ResponseEntity<>((kardex),HttpStatus.OK);
			}else {
				return new ResponseEntity<>((new Mensajes(false, "Error, no se encontro ninguna califcacion asociada a ese alumno")),HttpStatus.OK);
			}
	}
	
	@PostMapping("/api/administrador/kardex/insertarkardex" )
	public ResponseEntity<?> insertarCurso(@RequestBody Kardex kardex) {
	    return new ResponseEntity<>(this.kardexservice.InsertarKardex(kardex),HttpStatus.OK); // Retorna una respuesta de éxito con código de estado HTTP 200
	}
	
	@PutMapping("/api/administrador/kardex/modificarkardex/{id}")
	  public ResponseEntity<?> actualizarCurso(@PathVariable("id") int  id, @RequestBody int califcacion) {
	    return ResponseEntity.ok(this.kardexservice.modificarcalifcacion(id, califcacion));
	  }
	
	@DeleteMapping("/api/administrador/kardex/borrarcalificacion/{id}")
	public ResponseEntity<?> eliminarcurso(@PathVariable("id") int  id)  {
		return new ResponseEntity<>(this.kardexservice.borrar_calificacion(id),HttpStatus.OK);
	  }
	
}
