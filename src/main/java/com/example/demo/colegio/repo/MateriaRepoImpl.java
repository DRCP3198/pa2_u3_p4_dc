package com.example.demo.colegio.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.colegio.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public Materia buscar(String codigo) {
		// TODO Auto-generated method stub

		TypedQuery<Materia> typedQuery = this.entityManager
				.createQuery("SELECT ma Materia ma where ma.codigo=:datoCodigo", Materia.class);
		typedQuery.setParameter("datodatoCodigo", codigo);
		return typedQuery.getSingleResult();
	}

}
