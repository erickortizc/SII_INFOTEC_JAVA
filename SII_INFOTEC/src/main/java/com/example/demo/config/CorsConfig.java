package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;







@Configuration
@EnableWebMvc
public class CorsConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/login/{usuario},{contrasena}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/obtenerusuarios").allowedOrigins("http://localhost:4200").allowedMethods("*");
				registry.addMapping("/login3/{usuario},{contrasena}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/insertarusuario")
			    .allowedOrigins("http://localhost:4200")
			    .allowedMethods("*")
			    .allowedHeaders("*") // Especifica solo el encabezado Content-Type como permitido y expuesto
			    .exposedHeaders("*") // Especifica solo el encabezado Location como expuesto
			    .allowCredentials(false)
			    .maxAge(3600);
				registry.addMapping("/obtenerporid").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/consultar/{username}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/modificarusuario/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/borrarusuario/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				
				// crud de materias
				registry.addMapping("/api/administrador/materia/obtenermaterias").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/materia/obtenermateria/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/materia/insertarmateria").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/materia/modificarmateria/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/materia/borrarmateria/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				
				//CRUD DE CURSO
				
				registry.addMapping("/api/administrador/cursos/obtenercursos").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/cursos/obtenercurso/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/cursos/insertarcurso").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/cursos/modificarcurso/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/cursos/borrarcurso/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				
				
				//apis de matriculas
				registry.addMapping("/api/administrador/matricula/obtenermatriculasnombres").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/matriculas/obtenermatriculas").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/matriculas/obtenermatricula/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/matriculas/insertarmateria").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/matriculas/modificarmatricula/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/matriculas/borrarmateria/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				
				//matriculas
				registry.addMapping("/api/administrador/kardex/obtenercalificacion/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/kardex/obtenercalificacioneswithname/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/kardex/obtenercalificaciones/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/kardex/insertarkardex").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/kardex/modificarkardex/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/kardex/borrarcalificacion/{id}").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				registry.addMapping("/api/administrador/matricula/matriculaswithname").allowedOrigins("http://localhost:4200").allowedMethods("*").exposedHeaders("*");
				
			}
		};
	}
	
	
}
