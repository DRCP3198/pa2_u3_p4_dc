package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.banco.Propietario;
import com.example.demo.repository.IPropietarioRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class PropietarioServiceImpl implements IPropietarioService {

	@Autowired
	private IPropietarioRepo iPropietarioRepo;

	@Override
	public void agregar(Propietario propietario) {
		this.iPropietarioRepo.insertar(propietario);
	}

}
