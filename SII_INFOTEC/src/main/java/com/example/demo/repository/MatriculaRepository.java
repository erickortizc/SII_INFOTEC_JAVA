package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
	@Query(
			  value = "SELECT * FROM matricula u WHERE u.usr_id= :usrId ;", 
			  nativeQuery = true)
    Matricula findByUsrId(@Param("usrId")int usrId);
}
