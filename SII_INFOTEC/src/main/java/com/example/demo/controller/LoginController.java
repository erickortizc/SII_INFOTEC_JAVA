package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.LoginService;


@Controller
public class LoginController {
	@Autowired
	public LoginService loginservice;
	
	@GetMapping("/login3/{usuario},{contrasena}")
	public ResponseEntity<?> obtenerusuarioporid(@PathVariable("usuario") String usuario, @PathVariable("contrasena") String contrasena){
		if(!(usuario.equals("") && usuario.equals(null) && contrasena.equals("") && contrasena.equals(null)) ) {
			return new ResponseEntity<>((this.loginservice.autentificacion(usuario,contrasena)),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(("error campos vacios"),HttpStatus.BAD_REQUEST);
		}
		
	
	}
	
}
