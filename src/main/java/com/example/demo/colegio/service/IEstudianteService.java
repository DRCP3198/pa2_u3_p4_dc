package com.example.demo.colegio.service;

import com.example.demo.colegio.Estudiante;

public interface IEstudianteService {

	public void agregar(Estudiante estudiante);

	public Estudiante encontrar(String cedula);

	public void modificar(Estudiante estudiante);

}
