package com.example.demo.colegio.service;

import com.example.demo.colegio.Materia;

public interface IMateriaService {
	
	public void agregar(Materia materia);
	public Materia  encontrar(String codigo);

}
