package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.modelo.banco.Cuenta;
import com.example.demo.modelo.banco.Propietario;
import com.example.demo.modelo.banco.Transferencia;
import com.example.demo.modelo.banco.service.ICuentaService;
import com.example.demo.modelo.banco.service.ITransferenciaService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P4DcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4DcApplication.class);

	@Autowired
	private ICuentaService iCuentaBancariaService;

	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//
//		//ASINCRONO  FUTURO SIN RESPUESTA
//		LOG.info("HILO: " + Thread.currentThread().getName());
//
//		// inicio
//
//		long tiempoInicial = System.currentTimeMillis();
//
//		List<Cuenta> lista = new ArrayList<>();
//
//		for (int i = 0; i <= 10; i++) {
//
//			Cuenta ctaOrigen = new Cuenta();
//
//			ctaOrigen.setNumero(String.valueOf(i));
//
//			ctaOrigen.setSaldo(new BigDecimal(100));
//
//			ctaOrigen.setTipo("A");
//
//			lista.add(ctaOrigen);
//			this.iCuentaBancariaService.agregarAsincrono(ctaOrigen);
//
//		}
//
//		// esto es igual
//		long tiempoFinal = System.currentTimeMillis();
//
//		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;
//
//		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
//
//		LOG.info("Tiempo transcurrido: " + tiempoTotal);
//
//		LOG.info("Se termino de procesar todo: ");
//		

//		// ASINCRONO FUTURO CON RESPUESTA
//		LOG.info("HILO: " + Thread.currentThread().getName());
//		long tiempoInicial = System.currentTimeMillis();
//		List<CompletableFuture<String>> listaRespuestas = new ArrayList<>();
//		List<Cuenta> lista = new ArrayList<>();
//		for (int i = 0; i <= 3; i++) {
//			Cuenta ctaOrigen = new Cuenta();
//			ctaOrigen.setNumero(String.valueOf(i));
//			ctaOrigen.setSaldo(new BigDecimal(100));
//			ctaOrigen.setTipo("A");
//			lista.add(ctaOrigen);
//			CompletableFuture<String> respuesta = this.iCuentaBancariaService.agregarAsincrono2(ctaOrigen);
//			listaRespuestas.add(respuesta);
//		}
//		// Una ves que tengo la lista de respuestas aqui es donde voy a esperar las
//		// respuestas.
//		//Sentencia que espera que termine de procesarse todos los hilos para obtener
//		//la respuesta
//		CompletableFuture<Void> test=CompletableFuture.allOf(listaRespuestas.get(0), listaRespuestas.get(1), listaRespuestas.get(2));
//		test.get();
//		LOG.info("Respuesta 0: "+ listaRespuestas.get(0).get());
//		LOG.info("Respuesta 1: "+ listaRespuestas.get(1).get());
//		LOG.info("Respuesta 2: "+ listaRespuestas.get(2).get());
////	
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;
//		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
//		LOG.info("Tiempo transcurrido: " + tiempoTotal);
//		LOG.info("Se termino de procesar todo: ");
		
		long tiempoInicial = System.currentTimeMillis();

		List<CompletableFuture<Integer>> listaEdades=new ArrayList<>();
		for(int i=0;i<10;i++) {
			int year=((int) (Math.random()*2022)) +1;
//			System.out.println(year);
			int month=((int) (Math.random()*11))+1;
//			System.out.println(month);
			int day=((int) (Math.random()*27))+1;
//			System.err.println(day);
			LocalDate localDate= LocalDate.of(year, month, day);
			listaEdades.add(iCuentaBancariaService.calcularEdad(localDate));
		}
		


		CompletableFuture.allOf(listaEdades.get(0),listaEdades.get(1),
				listaEdades.get(2),listaEdades.get(3),
				listaEdades.get(4),listaEdades.get(5),
				listaEdades.get(6),listaEdades.get(7),
				listaEdades.get(8),listaEdades.get(9));

		float suma=0;
		for (CompletableFuture<Integer> cf : listaEdades) {
			LOG.info("EDAD: "+cf.get());
			suma=suma+(float) cf.get();
		}
		float promedio=suma/listaEdades.size();
		LOG.info("El promedio de las 10 edades es: "+promedio);

		long tiempoFinal = System.currentTimeMillis();
		LOG.info("Tiempo transcurido: " + (tiempoFinal-tiempoInicial));



	


	}

}
