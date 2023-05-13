package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.multipart.MultipartResolver;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
@Configuration
public class MultipartConfig {
	   @Bean
	   public MultipartConfigElement multipartConfigElement() {
	        String location = "c:/Users/Eri1ck_2021/Pictures/imagenes/"; // Ruta temporal para almacenar los archivos subidos
	        Long maxFileSize = 5242880L; // Tamaño máximo de archivo en bytes (5 MB)
	        Long maxRequestSize = 5242880L; // Tamaño máximo de solicitud en bytes (5 MB)
	        int fileSizeThreshold = 0; // Umbral de tamaño de archivo en bytes para escribir en disco

	        return new MultipartConfigElement(location, maxFileSize, maxRequestSize, fileSizeThreshold);
	    }

	    
}
