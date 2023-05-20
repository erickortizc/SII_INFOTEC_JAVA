package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.KardexwithCategoria;
import com.example.demo.dto.UsuarioKardexCV;
import com.example.demo.entity.CV;
import com.example.demo.entity.Kardex;
import com.example.demo.entity.Matricula;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.KardexRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.cvRepository;
@Service
public class UsuariosKardexCvService {
	private MatriculaRepository matricularepo;
	private UsuarioRepository usuariorepo;
	private KardexRepository kardexrepo;
	private cvRepository cvRepository;
	
	public UsuariosKardexCvService(UsuarioRepository usuariorepo,MatriculaRepository matricularepo, KardexRepository kardexrepo, cvRepository cvRepository) {
		this.usuariorepo = usuariorepo;
		this.matricularepo = matricularepo;
		this.kardexrepo = kardexrepo;
		this.cvRepository = cvRepository;
	}
	
	public List<UsuarioKardexCV> obtenertodos(){
		List<UsuarioKardexCV> lista = new ArrayList<>();
		for(Matricula m:matricularepo.findAll()) {
			double promedio=0;
			int contadormaterias=0;
			String nombre_completo;
			String ruta="";
			Usuario user = this.usuariorepo.findById(m.getUsr_id()).get();
			nombre_completo = user.getNombre() +" " + user.getApellido_paterno() +" " + user.getApellido_materno();
			for(Kardex k:this.kardexrepo.findAll()) {
				if(k.getMtc_id()==m.getMtc_id()) {
					promedio+=k.getKrd_calificacion();
					contadormaterias++;
				}
			}
			for(CV c:this.cvRepository.findAll()) {
				if(c.getUsr_id()==m.getUsr_id()) {
					ruta=c.getCv_nombre_archivo();
				}
			}
			lista.add(new UsuarioKardexCV(user.getId(),nombre_completo,user.getNombre_usuario(),(promedio/contadormaterias),ruta));
			
		}
		
		
		return lista;
	}
	public List<UsuarioKardexCV> obtenertodosbycategoria(String categoria){
		List<UsuarioKardexCV> lista = new ArrayList<>();
		for(Matricula m:matricularepo.findAll()) {
			boolean encontrado=false;
			double promedio=0;
			int contadormaterias=0;
			String nombre_completo;
			String ruta="";
			Usuario user = this.usuariorepo.findById(m.getUsr_id()).get();
			nombre_completo = user.getNombre() +" " + user.getApellido_paterno() +" " + user.getApellido_materno();
			for(KardexwithCategoria k:getKardexWithCategoria(categoria)) {
				if(k.getMtc_id()==m.getMtc_id()) {
					promedio+=k.getKrd_calificacion();
					contadormaterias++;
					encontrado=true;
				}
			}
			for(CV c:this.cvRepository.findAll()) {
				if(c.getUsr_id()==m.getUsr_id()) {
					ruta=c.getCv_nombre_archivo();
				}
			}
			if(encontrado) {
				lista.add(new UsuarioKardexCV(user.getId(),nombre_completo,user.getNombre_usuario(),(promedio/contadormaterias),ruta));
			}
			
		}
		
		
		return lista;
	}
	
	 public List<KardexwithCategoria> getKardexWithCategoria(String categoria) {
	        List<Object[]> results = kardexrepo.findwithcategoria(categoria);
	        List<KardexwithCategoria> kardexWithCategoriaList = new ArrayList<>();

	        for (Object[] result : results) {
	            KardexwithCategoria kardexWithCategoria = new KardexwithCategoria();
	            kardexWithCategoria.setKrd_id((int) result[0]);
	            kardexWithCategoria.setKrd_calificacion((int) result[1]);
	            kardexWithCategoria.setMtc_id((int) result[2]);
	            kardexWithCategoria.setMtr_categoria((String) result[3]);

	            kardexWithCategoriaList.add(kardexWithCategoria);
	        }

	        return kardexWithCategoriaList;
	    }
}
