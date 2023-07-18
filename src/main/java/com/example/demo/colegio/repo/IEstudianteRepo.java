package com.example.demo.colegio.repo;

import com.example.demo.colegio.Estudiante;

public interface IEstudianteRepo {
	
	public void insertar(Estudiante estudiante);
	public Estudiante buscar(String cedula);
	public void actualizar(Estudiante estudiante);

}
