package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.colegio.Estudiante;
import com.example.demo.colegio.Materia;
import com.example.demo.colegio.service.IEstudianteService;
import com.example.demo.colegio.service.IMateriaService;
import com.example.demo.colegio.service.IMatriculaService;
import com.example.demo.modelo.banco.Cuenta;
import com.example.demo.modelo.banco.Propietario;
import com.example.demo.modelo.banco.Transferencia;
import com.example.demo.modelo.banco.service.ICuentaService;
import com.example.demo.modelo.banco.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4DcApplication implements CommandLineRunner {

	@Autowired
	private IMatriculaService iMatriculaService;

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService iMateriaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		Estudiante e = new Estudiante();
		e.setNombre("Henry");
		e.setApellido("Coyago");
		e.setCedula("1213141516");
		e.setFacultad("Filosofía");
		this.estudianteService.agregar(e);
		
		
		
		Materia mat = new Materia();
		mat.setAula("A12");
		mat.setCodigo("1212");
		mat.setCreditos(100);
		mat.setNombre("Ciencias Sociales");

		Materia mat1 = new Materia();
		mat1.setAula("A13");
		mat1.setCodigo("1213");
		mat1.setCreditos(100);
		mat1.setNombre("Ciencias Naturales");
		
	
		Materia mat2 = new Materia();
		mat2.setAula("A14");
		mat2.setCodigo("1214");
		mat2.setCreditos(100);
		mat2.setNombre("Ciencias Matemáticas");
		
		
		this.iMateriaService.agregar(mat);
		this.iMateriaService.agregar(mat2);
		this.iMateriaService.agregar(mat1);
		List<String> codMaterias = new ArrayList<>();
		codMaterias.add("1214");
		codMaterias.add("1212");
		codMaterias.add("1213");
		this.iMatriculaService.matricular("1213141516", codMaterias);
		

	}

}
