package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Hotel;
import com.example.demo.repository.IHotelRepo;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4DcApplication implements CommandLineRunner{

	@Autowired
	private IHotelService iHotelService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Hotel> reporte = this.iHotelService.buscarInnerJoin();
		for (Hotel hotel : reporte) {
			System.out.println(hotel);
		}
	}

}
