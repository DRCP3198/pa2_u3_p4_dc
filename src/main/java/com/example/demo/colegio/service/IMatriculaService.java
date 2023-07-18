package com.example.demo.colegio.service;

import java.util.List;

import com.example.demo.colegio.Materia;

public interface IMatriculaService {
	
	
	public void matricular(String cedula, List<String> codigos);
    
}
