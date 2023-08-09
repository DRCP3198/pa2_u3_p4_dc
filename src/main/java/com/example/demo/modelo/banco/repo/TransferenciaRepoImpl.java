package com.example.demo.modelo.banco.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.funcional.MetodosReferenciados;
import com.example.demo.modelo.banco.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class TransferenciaRepoImpl implements ITransferenciaRepo{
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados .class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
	
		this.entityManager.persist(transferencia);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Transferencia> seleccionarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Transferencia> myQuery = this.entityManager.createQuery("select t from Transferencia t",
				Transferencia.class);
		return myQuery.getResultList();
	}
	
	
	

}
