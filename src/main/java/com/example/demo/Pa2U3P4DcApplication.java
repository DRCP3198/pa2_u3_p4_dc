package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.colegio.Estudiante;
import com.example.demo.colegio.Materia;
import com.example.demo.colegio.Provincia;
import com.example.demo.colegio.Semestre;
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
        
		Provincia pro = new  Provincia();
		pro.setCapital("Quito");
		pro.setCodPostal("A1234");
		pro.setNombre("Pichincha");
//		
//		Semestre semestre = new Semestre();
//		semestre.setPeriodo("2023-2024");
//		semestre.setFechaInicio(LocalDate.now());
//		semestre.setFechaFin(LocalDate.of(2024, 1, 23));
//		
//		
		
		Estudiante e = new Estudiante();
		e.setNombre("Andres");
		e.setApellido("Coyantes");
		e.setCedula("1213141520");
		e.setFacultad("Ingenieria");
		
		//pro.setEstudiante(listaEstudiantes);
		e.setProvinvia(pro);
		this.estudianteService.agregar(e);
		
		
		
		Materia mat = new Materia();
		mat.setAula("B12");
		mat.setCodigo("1314");
		mat.setCreditos(100);
		mat.setNombre("Programación");

		Materia mat1 = new Materia();
		mat1.setAula("A13");
		mat1.setCodigo("1315");
		mat1.setCreditos(100);
		mat1.setNombre("Filosofia");
		
	
		Materia mat2 = new Materia();
		mat2.setAula("A14");
		mat2.setCodigo("1316");
		mat2.setCreditos(100);
		mat2.setNombre("Ciencias Matemáticas");
		
		
		this.iMateriaService.agregar(mat);
		this.iMateriaService.agregar(mat2);
		this.iMateriaService.agregar(mat1);
		List<String> codMaterias = new ArrayList<>();
		codMaterias.add("1214");
		codMaterias.add("1212");
		codMaterias.add("1213");
		this.iMatriculaService.matricular("1213141520", codMaterias);
		

	}

}
