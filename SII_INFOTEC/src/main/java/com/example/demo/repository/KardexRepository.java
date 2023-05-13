package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Kardex;

public interface KardexRepository extends JpaRepository<Kardex, Integer>{
	@Query(value = "SELECT * FROM kardex u WHERE u.mtc_id= :mtrId ;", 
			  nativeQuery = true)
    List<Kardex> findByMtrId(@Param("mtrId") int mtrId);
	
	
}
