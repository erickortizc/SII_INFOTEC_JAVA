package com.example.demo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Mensajes;
import com.example.demo.entity.CV;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.cvService;

@RestController
public class cvController {
	private final cvService cvservice;
	private final UsuarioService usuarioservice;
	
	@Autowired
	public cvController(cvService cvservice,UsuarioService usuarioservice) {
		this.cvservice = cvservice;
		this.usuarioservice=usuarioservice;
	}
	@GetMapping("/api/alumno/cv/obtenercv/{id}")
	public ResponseEntity<?> obtenercvbyid(@PathVariable("id") int  id)  {
		CV cv = this.cvservice.buscarbyusr_id(id);
		if(cv!=null) {
			return new ResponseEntity<>(cv,HttpStatus.OK);
		}else {
			return new ResponseEntity<>((new Mensajes(false, "Error no has subido un cv, sube uno.")),HttpStatus.OK);
		}
		
	 }
	//guardar cv
	@PostMapping("/api/alumno/cv/guardarcv")
	public ResponseEntity<?> subirCV(@RequestParam("file") MultipartFile file,
            @RequestParam("usr_id") int userId) {
		if (file.isEmpty()) {
			return new ResponseEntity<>((new Mensajes(false, "Error archivo vacio")),HttpStatus.OK);
        }
		try {
			
            // Guardar el archivo en el servidor
		
            String fileName = file.getName()+"_"+userId+".pdf"; //obteniendo el nombre del archivo
            
            String filePath = "C:/Users/Eri1ck_2021/SII_INFOTEC/src/assets/MEDIA/CV's/" + fileName; //obteniendo la ruta del archivo
          
            file.transferTo(new File(filePath)); //gurdando el archivo en una carpeta en especifico
     
            // Crear instancia de CV y guardarla en la base de datos
            CV cv = new CV();
            cv.setCv_nombre_archivo(fileName);
            cv.setCv_url(filePath);
            cv.setUsr_id(userId);

            CV cvGuardado = cvservice.guardarcv(cv);
            if(cvGuardado!=null) {
            	return new ResponseEntity<>((new Mensajes(false, "Se ha subido su cv")),HttpStatus.OK);
            }else {
            	return new ResponseEntity<>((new Mensajes(false, "Error, no se subido su cv porque ya tiene un registrado")),HttpStatus.OK);
            }
            
        } catch (IOException e) {
        	System.out.println(e);
        	return new ResponseEntity<>((new Mensajes(false, "Error al subir archivo")),HttpStatus.OK);
        }
	}
	//guardar cv
			@PostMapping("/insertarusuariowithphoto")
			public ResponseEntity<?> subirphoto(@RequestParam("file") MultipartFile file,
					 @ModelAttribute  Usuario user) {
				if (file.isEmpty()) {
					return new ResponseEntity<>((new Mensajes(false, "Error imagen vacio")),HttpStatus.OK);
		        }
				try {
					
		            // Guardar el archivo en el servidor
				
		            String fileName = file.getName()+"_"+user.getNombre_usuario()+".jpg"; //obteniendo el nombre del archivo
		            
		            String filePath = "C:/Users/Eri1ck_2021/SII_INFOTEC/src/assets/MEDIA/Fotos_perfil/" + fileName; //obteniendo la ruta del archivo
		          
		            file.transferTo(new File(filePath)); //gurdando el archivo en una carpeta en especifico
		     
		            // Crear instancia de CV y guardarla en la base de datos
		            user.setRuta(fileName);
		            	return new ResponseEntity<>((this.usuarioservice.InsertarUsuario(user)),HttpStatus.OK); // Retorna una respuesta de éxito con código de estado HTTP 200
		            
		        } catch (IOException e) {
		        	System.out.println(e);
		        	return new ResponseEntity<>((new Mensajes(false, "Error al subir archivo")),HttpStatus.OK);
		        }
			}
	@DeleteMapping("/api/alumno/cv/eliminarcv/{id}")
	public ResponseEntity<?> eliminarcv(@PathVariable("id") int  id)  {
		return new ResponseEntity<>(this.cvservice.borrarcv(id),HttpStatus.OK);
	  }
	
	
}
