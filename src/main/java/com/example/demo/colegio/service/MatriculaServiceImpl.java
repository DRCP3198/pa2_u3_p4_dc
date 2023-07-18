package com.example.demo.colegio.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.colegio.Estudiante;
import com.example.demo.colegio.Materia;
import com.example.demo.colegio.Matricula;
import com.example.demo.colegio.repo.IEstudianteRepo;
import com.example.demo.colegio.repo.IMateriaRepo;
import com.example.demo.colegio.repo.IMatriculaRepo;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMateriaRepo iMateriaRepo;
	
	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Autowired
	private IMatriculaRepo iMatriculaRepo;
	
	@Override
	public void matricular(String cedula, List<String> codigosLista) {
		// TODO Auto-generated method stub
		
		
		
		Estudiante e = this.estudianteRepo.buscar(cedula);
		for (String codigo : codigosLista) {
			Materia materia= this.iMateriaRepo.buscar(codigo);
			Matricula matricula = new Matricula();
			matricula.setTipo("ordinaria");
			matricula.setNumCreditos("100");
			matricula.setFecha(LocalDate.now());
			matricula.setEstudiante(e);
			matricula.setMateria(materia);
			//this.iMateriaRepo.insertar(materia);
			this.iMatriculaRepo.insertar(matricula);
		
  		}
	
         System.out.println("Se Genero la Matricula");	
		
	}

}
