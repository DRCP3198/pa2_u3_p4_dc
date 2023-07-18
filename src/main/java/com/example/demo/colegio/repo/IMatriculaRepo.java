package com.example.demo.colegio.repo;

import com.example.demo.colegio.Matricula;

public interface IMatriculaRepo {
	
	public void insertar(Matricula matricula);
	public Matricula buscaMatricula(Integer id );
	

}
