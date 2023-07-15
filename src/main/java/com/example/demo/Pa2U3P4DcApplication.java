package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.repository.IHotelRepo;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4DcApplication implements CommandLineRunner {

	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Habitacion> habitacions= new ArrayList<>();
		Hotel a = new Hotel();
		a.setDireccion("12 de octubre");
		a.setNombre("Norman");
		
		Habitacion h = new Habitacion();
		h.setNumero("NM1");
		h.setValor(new BigDecimal(250));
		h.setHotel(a);
		habitacions.add(h);
		
		Habitacion h1 = new Habitacion();
		h1.setNumero("NM2");
		h1.setValor(new BigDecimal(230));
		h1.setHotel(a);
		habitacions.add(h1);
		
		a.setHabitaciones(habitacions);
		
		Habitacion h2 = new Habitacion();
		h2.setNumero("NM3");
		h2.setValor(new BigDecimal(245));
		h2.setHotel(a);
		habitacions.add(h2);
		
		a.setHabitaciones(habitacions);
        this.iHotelService.agregar(a);
		
		System.out.println("INNER JOIN");
		List<Hotel> reporte = this.iHotelService.buscarInnerJoin();
		for (Hotel hotel : reporte) {
			System.out.println(hotel.getNombre());
			System.out.println("Tiene las siguientes habitaciones");
			for (Habitacion hab : hotel.getHabitaciones()) {
				System.out.println(hab.getNumero());
			}

		}
		System.out.println();
		System.out.println("JOIN FETCH");
		List<Hotel> reporte1 = this.iHotelService.buscarFetchJoin();
		for (Hotel hotel : reporte1) {
			System.out.println(hotel.getNombre());
			System.out.println("Tiene las siguientes habitaciones");
			for (Habitacion hab : hotel.getHabitaciones()) {
				System.out.println(hab.getNumero());
			}

		}

	}

}
