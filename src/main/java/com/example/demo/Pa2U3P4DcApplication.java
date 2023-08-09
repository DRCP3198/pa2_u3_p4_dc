package com.example.demo;

import java.math.BigDecimal;
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

		// ASINCRONO FUTURO CON RESPUESTA
		LOG.info("HILO: " + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		List<CompletableFuture<String>> listaRespuestas = new ArrayList<>();
		List<Cuenta> lista = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			Cuenta ctaOrigen = new Cuenta();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setSaldo(new BigDecimal(100));
			ctaOrigen.setTipo("A");
			lista.add(ctaOrigen);
			CompletableFuture<String> respuesta = this.iCuentaBancariaService.agregarAsincrono2(ctaOrigen);
			listaRespuestas.add(respuesta);
		}
		// Una ves que tengo la lista de respuestas aqui es donde voy a esperar las
		// respuestas.
		//Sentencia que espera que termine de procesarse todos los hilos para obtener
		//la respuesta
		CompletableFuture.allOf(listaRespuestas.get(0), listaRespuestas.get(1), listaRespuestas.get(2),
				listaRespuestas.get(3), listaRespuestas.get(4), listaRespuestas.get(5), listaRespuestas.get(6),
				listaRespuestas.get(7), listaRespuestas.get(8), listaRespuestas.get(9));
		
		LOG.info("Respuesta 0: "+ listaRespuestas.get(0).get());
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: " + tiempoTotal);
		LOG.info("Se termino de procesar todo: ");

	}

}
