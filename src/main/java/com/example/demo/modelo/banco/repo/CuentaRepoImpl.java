package com.example.demo.modelo.banco.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.banco.Cuenta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CuentaRepoImpl implements ICuentaRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Cuenta cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
	public Cuenta seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cuenta.class, id);
	}

	@Override
	public void actualizar(Cuenta cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
		
	}

}
