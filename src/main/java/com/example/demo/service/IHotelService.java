package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

public interface IHotelService {
	
	public List<Hotel> buscarInnerJoin();
	public List<Hotel> buscarOuterRightJoin();
	public List<Hotel> buscarOuterLeftJoin();
	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	public List<Hotel> buscarFulltJoin();
	public List<Hotel> buscarWhereJoin();
	public List<Hotel> buscarFetchJoin();
	public void agregar(Hotel hotel);

	

}
