package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CV;

public interface cvRepository extends JpaRepository<CV, Integer> {
	@Query(
			  value = "SELECT * FROM cv u WHERE u.usr_id= :usr_id ;", 
			  nativeQuery = true)
	CV buscarbyusrid(@Param("usr_id") int usr_id);
}
