package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

public interface IHotelRepo {
	public void insertar(Hotel hotel);

	// INNER JOIN
	public List<Hotel> seleccionarInnerJoin();

	// RightJoin
	public List<Hotel> seleccionarOuterRightJoin();

	// LeftJoin
	public List<Hotel> seleccionarOuterLeftJoin();
	
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin();
    //Full JOIN
	public List<Hotel> seleccionarFulltJoin();
	
	//JOIN WHERE
	public List<Hotel> seleccionarWhereJoin();
	
	//JOIN FETCH
	public List<Hotel> seleccionarFetchJoin();

}
