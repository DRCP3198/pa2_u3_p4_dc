package com.example.demo.colegio.repo;

import java.util.List;

import com.example.demo.colegio.Materia;

public interface IMateriaRepo {
	
	public void insertar(Materia materia);
	public Materia  buscar(String codigo);
	

}
