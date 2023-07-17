package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.banco.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class PropietarioRepoImpl implements IPropietarioRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Propietario propietario) {
		this.entityManager.persist(propietario);
	}
	
	

}
