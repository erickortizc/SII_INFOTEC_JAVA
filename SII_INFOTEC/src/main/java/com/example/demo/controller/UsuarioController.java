package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Mensajes;
import com.example.demo.entity.Usuario;

import com.example.demo.service.UsuarioService;



@Controller
public class UsuarioController {
	@Autowired
	public UsuarioService usuarioservice;
	//Obtener toodos los usuarios
	@GetMapping("/obtenerusuarios")
	
	public ResponseEntity<?> obtenerusuarios(){
		return new ResponseEntity<>((this.usuarioservice.obtenertodos()),HttpStatus.OK);
	
	}
	
	
	
	@PostMapping("/insertarusuario" )
	public ResponseEntity<?> insertarUsuario(@RequestBody Usuario usuario) {
	  /*  if (!archivo.isEmpty()) {
	        try {
	            // Obtén el nombre del archivo y genera una ruta única para guardarlo
	            String nombreArchivo = StringUtils.cleanPath(archivo.getOriginalFilename());
	            String rutaArchivo = "c:/Users/Eri1ck_2021/Pictures/imagenes/perfil/" + nombreArchivo; // Ruta donde deseas guardar el archivo

	            // Guarda el archivo en el sistema de archivos
	            Files.copy(archivo.getInputStream(), Paths.get(rutaArchivo), StandardCopyOption.REPLACE_EXISTING);

	            // Guarda la ruta del archivo en el atributo 'ruta' del objeto 'usuario'
	            usuario.setRuta(rutaArchivo);
	        } catch (IOException e) {
	            // Maneja cualquier excepción que pueda ocurrir durante la carga y guardado del archivo
	            e.printStackTrace();
	            // Puedes lanzar una excepción personalizada o retornar un mensaje de error apropiado
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    } */
		
	    
		return new ResponseEntity<>((this.usuarioservice.InsertarUsuario(usuario)),HttpStatus.OK); // Retorna una respuesta de éxito con código de estado HTTP 200
	}
	@GetMapping("/consultar/{username}")
	public ResponseEntity<?> consultar(@PathVariable("username") String usuario){
		if(usuario !=null || !usuario.equals("")){
			return new ResponseEntity<>((this.usuarioservice.consultarbyid(usuario)),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@PutMapping("/modificarusuario/{id}")
	  public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("id") int  id, @RequestBody Usuario usuarioActualizado) {
	    Usuario usuarioActualizadoGuardado = usuarioservice.actualizarUsuario(id, usuarioActualizado);
	    return ResponseEntity.ok(usuarioActualizadoGuardado);
	  }
	@DeleteMapping("/borrarusuario/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable(value = "id") int usuarioId) {
	    Usuario usuario = usuarioservice.buscarPorId(usuarioId);
	    if(usuario == null) {
	        return ResponseEntity.notFound().build();
	    }
	    usuarioservice.eliminar(usuario);
	    return ResponseEntity.ok().build();
	}
	//login 
	@GetMapping("/login/{usuario},{contrasena}")
	public ResponseEntity<?> loginbyusuario(@PathVariable("usuario") String usuario, @PathVariable("contrasena") String contrasena){
		
		if(!(usuario.equals("") && usuario.equals(null) && contrasena.equals("") && contrasena.equals(null)) ) {
			Usuario user=this.usuarioservice.autentificacion(usuario,contrasena);
			if(user!=null) {
				return new ResponseEntity<>((user),HttpStatus.OK);
			}else {
				return new ResponseEntity<>((new Mensajes(false,"Error usuario o contraseña incorrecta")),HttpStatus.OK);
			}
			
		}else {
			return new ResponseEntity<>(new Mensajes(false,"Error no se encontro el usuario"),HttpStatus.BAD_REQUEST);
		}
	}
}
