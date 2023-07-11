package com.example.demo.repository;

import java.util.List;

import org.hibernate.engine.jdbc.Size;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo {

	@PersistenceContext
	private EntityManager entityManager;

	//INNER JOIN
	@Override
	public List<Hotel> seleccionarInnerJoin() {
		
		//select * from hotel h  join habitacion ha on h.hote_id=ha.habitacion_id_hotel
		//hago referencia a donde tengo mi habitación
		//SELECT h from Hotel h JOIN h.habitaciones ha 
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h from Hotel h JOIN h.habitaciones ha ", Hotel.class);
		return query.getResultList();
	}

	
}
