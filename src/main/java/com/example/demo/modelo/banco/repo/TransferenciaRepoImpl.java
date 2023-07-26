package com.example.demo.modelo.banco.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.banco.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class TransferenciaRepoImpl implements ITransferenciaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
	
		this.entityManager.persist(transferencia);
		
	}

	@Override
	public List<Transferencia> seleccionarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Transferencia> myQuery = this.entityManager.createQuery("select t from Transferencia t",
				Transferencia.class);
		return myQuery.getResultList();
	}
	
	
	

}
