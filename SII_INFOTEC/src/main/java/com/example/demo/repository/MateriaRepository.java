package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {
	
}
