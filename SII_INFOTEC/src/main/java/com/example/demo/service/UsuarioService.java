package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo.Mensajes;
import com.example.demo.dto.Login;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	 private UsuarioRepository usuariorepo;


	 
	 
	 public UsuarioService(UsuarioRepository usuariorepo) {
		 this.usuariorepo = usuariorepo;
	}
	 public List<Usuario> obtenertodos() {
			return this.usuariorepo.findAll();
	}
	 public void InsertarUsuario(Integer id, String nombre, String apellido_paterno, String apellido_materno, String email, String nombre_usuario,
				String contrasena, String telefono,  String estado, String municipio, String codigo_postal, 
				String calle, String numero_casa, String  ruta, Integer rol_id, boolean usr_activo) {
		 
		 Usuario nuevousuario = new Usuario(id, nombre, apellido_paterno, apellido_materno, email, nombre_usuario, 
				 contrasena, telefono, estado, municipio, codigo_postal, calle, numero_casa, ruta, rol_id, usr_activo);
		 this.usuariorepo.save(nuevousuario);
	 }
	 public Mensajes  InsertarUsuario(Usuario user1) {
		 List<Usuario> usuarios = this.usuariorepo.findAll();
		 boolean estado=false;
		 boolean estado2=false;
		 for(Usuario u:usuarios) {
			 if(u.getEmail().equals(user1.getEmail())) {
				 estado=true;
			 }
			 if(u.getNombre_usuario().equals(user1.getNombre_usuario())) {
				 estado2=true;
			 }
		 }
		 if(!estado && !estado2) {
			 this.usuariorepo.save(user1);
			 return new Mensajes(false,"Usuario registrado");
		 }else
		 if(estado) {
			 return new Mensajes(false,"ERROR, EMAIL REPETIDO");
		 }else
			 if(estado2) {
				 return new Mensajes(false,"ERROR, USUARIO REPETIDO");
			 }else {
				 return null;
			 }
		 
	 }
	 public Usuario consultarbyid(String username) {
		 return this.usuariorepo.consultar(username);
	 }
	 public Usuario actualizarUsuario(int id, Usuario usuarioActualizado) {
		    Optional<Usuario> optionalUsuario = usuariorepo.findById(id);
		    if (optionalUsuario.isPresent()) {
		      Usuario usuarioExistente = optionalUsuario.get();
		      usuarioExistente.setNombre(usuarioActualizado.getNombre());
		      usuarioExistente.setApellido_paterno(usuarioActualizado.getApellido_paterno());
		      usuarioExistente.setApellido_materno(usuarioActualizado.getApellido_materno());
		      usuarioExistente.setEmail(usuarioActualizado.getEmail());
		      usuarioExistente.setNombre_usuario(usuarioActualizado.getNombre_usuario());
		      usuarioExistente.setContrasena(usuarioActualizado.getContrasena());
		      usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
		      usuarioExistente.setEstado(usuarioActualizado.getEstado());
		      usuarioExistente.setMunicipio(usuarioActualizado.getMunicipio());
		      usuarioExistente.setCodigo_postal(usuarioActualizado.getCodigo_postal());
		      usuarioExistente.setCalle(usuarioActualizado.getCalle());
		      usuarioExistente.setNumero_casa(usuarioActualizado.getNumero_casa());
		      usuarioExistente.setRuta(usuarioActualizado.getRuta());
		      usuarioExistente.setRol_id(usuarioActualizado.getRol_id());
		      return usuariorepo.save(usuarioExistente);
		    } else {
		    	Usuario user = new Usuario();
				return user;
		    }
		  }
	 public void eliminar(Usuario usuario) {
		    usuariorepo.delete(usuario);
		}
	 public Usuario buscarPorId (int id) {
		 return usuariorepo.findById(id).get();
	 }
	 
	 
	 //login 
	 public Usuario autentificacion(String username, String password) {
		 	try {
		 		return this.usuariorepo.autentificacion(username, password);
		 	}catch(Exception e) {
		 		return null;
		 	}
			
	}
}
