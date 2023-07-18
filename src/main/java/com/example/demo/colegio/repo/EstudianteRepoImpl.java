package com.example.demo.colegio.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.colegio.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);

	}

	@Override
	public Estudiante buscar(String cedula) {
		// TODO Auto-generated method stub

		TypedQuery<Estudiante> typedQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e where e.cedula=:datoCedula", Estudiante.class);
		typedQuery.setParameter("datoCedula", cedula);
		return typedQuery.getSingleResult();
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);

	}

}
