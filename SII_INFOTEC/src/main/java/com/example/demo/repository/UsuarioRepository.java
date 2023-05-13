package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.Login;
import com.example.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query(
			  value = "SELECT * FROM Usuario u WHERE u.usr_username= :username and u.usr_password= :contrasena ;", 
			  nativeQuery = true)
	Usuario autentificacion(@Param("username") String username, @Param("contrasena") String password);
	
	@Query(
			  value = "select * from vw_inicio_sesion where usuario= :username and contrasena= :contrasena ;", 
			  nativeQuery = true)
	Usuario autentificacion2(@Param("username") String username, @Param("contrasena") String password);
	
	@Query(
			  value = "select * from usuario u where u.rol_id =2 and u.usr_username =:username ;", 
			  nativeQuery = true)
	Usuario consultar(@Param("username") String username);

	

	

}
