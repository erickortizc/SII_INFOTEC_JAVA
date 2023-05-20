package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.UsuariosKardexCvService;

@Controller
public class UsuarioKardexCvController {
	@Autowired
	private UsuariosKardexCvService kardexservice;
	
	@GetMapping("/api/administrador/CV/obtenercvs")
	public ResponseEntity<?> obtenertodos(){
		
			return new ResponseEntity<>((this.kardexservice.obtenertodos()),HttpStatus.OK);
		
			
	}
	@GetMapping("/api/administrador/CV/obtenercvs/{categoria}")
	public ResponseEntity<?> obtenertodosbycategoria(@PathVariable("categoria") String categoria){
		
			return new ResponseEntity<>((this.kardexservice.obtenertodosbycategoria(categoria)),HttpStatus.OK);
		
			
	}
	@GetMapping("/api/administrador/CV/obtenercvs2/{categoria}")
	public ResponseEntity<?> obtenertodosbycategoria2(@PathVariable("categoria") String categoria){
		
			return new ResponseEntity<>((this.kardexservice.getKardexWithCategoria(categoria)),HttpStatus.OK);
		
			
	}
}
