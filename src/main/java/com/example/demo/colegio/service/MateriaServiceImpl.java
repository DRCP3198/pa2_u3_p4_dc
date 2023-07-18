package com.example.demo.colegio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.colegio.Materia;
import com.example.demo.colegio.repo.IMateriaRepo;

@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private IMateriaRepo iMateriaRepo;

	@Override
	public void agregar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepo.insertar(materia);
	}

	@Override
	public Materia encontrar(String codigo) {
		// TODO Auto-generated method stub
		return this.iMateriaRepo.buscar(codigo);
	}

}
