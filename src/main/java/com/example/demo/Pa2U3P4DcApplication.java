package com.example.demo;

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
       System.out.println("INNER JOIN");
		List<Hotel> reporte = this.iHotelService.buscarInnerJoin();
		for (Hotel hotel : reporte) {
			System.out.println(hotel);
		}
		System.out.println("Right Join");
		List<Hotel> reporte1 = this.iHotelService.buscarOuterRightJoin();
		for (Hotel hotel1 : reporte1) {
				System.out.println(hotel1);
			
		}
		System.out.println("LEFT Join");
		List<Hotel> reporte2 = this.iHotelService.buscarOuterLeftJoin();
		for (Hotel hotel2 : reporte2) {
				System.out.println(hotel2);
			
		}
//		System.out.println("Left Join Habitaciones");
//		List<Habitacion> reporte3 = this.iHotelService.buscarHabitacionOuterLeftJoin();
//		for (Habitacion habitacion : reporte3) {
//			System.out.println(reporte3);
//		}
//		
		System.out.println("FULL Join");
		List<Hotel> reporte4 = this.iHotelService.buscarFulltJoin();
		for (Hotel hotel : reporte4) {
				System.out.println(hotel.getNombre());
			
		}
		System.out.println("WHERE Join");
		List<Hotel> reporte5 = this.iHotelService.buscarWhereJoin();
		for (Hotel hotel : reporte5) {
				System.out.println(hotel);
			
		}
	}

}
