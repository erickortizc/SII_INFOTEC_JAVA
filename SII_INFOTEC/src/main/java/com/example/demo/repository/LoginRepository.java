package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.Login;


public interface LoginRepository extends JpaRepository<Login, Integer>{
	@Query(
			  value = "SELECT * FROM vw_inicio_sesion u WHERE u.usuario= :username and u.contrasena= :contrasena ;", 
			  nativeQuery = true)
	Login autentificacion(@Param("username") String username, @Param("contrasena") String password);
}
