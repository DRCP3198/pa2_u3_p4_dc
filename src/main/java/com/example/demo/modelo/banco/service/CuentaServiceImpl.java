package com.example.demo.modelo.banco.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.banco.Cuenta;
import com.example.demo.modelo.banco.repo.ICuentaRepo;

@Service 
public class CuentaServiceImpl implements ICuentaService{
	
	private static final Logger LOG = LoggerFactory.getLogger(CuentaServiceImpl.class);
	
	@Autowired
	private ICuentaRepo cuentaRepo;

	@Override
	public void agregar(Cuenta cuentaBancaria) {
		int i=1;
		// TODO Auto-generated method stub
		LOG.info("HILO: " + Thread.currentThread().getName());

		try {
			TimeUnit.SECONDS.sleep(1);
			this.cuentaRepo.insertar(cuentaBancaria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			i=0;
		}
		
		// TODO Auto-generated method stub
		
		
	}
	

	@Override
	public Cuenta encontrarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.cuentaRepo.seleccionarPorId(id);
	}

	@Override
	public void modificar(Cuenta cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaRepo.actualizar(cuentaBancaria);
	}


	@Override
	public String agregar2(Cuenta bancaria) {
		LOG.info("HILO: " + Thread.currentThread().getName());

		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cuentaRepo.insertar(bancaria);
		return bancaria.getNumero();
	}


	@Override
	@Async
	public void agregarAsincrono(Cuenta cuenta) {
		// TODO Auto-generated method stub
		LOG.info("HILO: " + Thread.currentThread().getName());

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		this.cuentaRepo.insertar(cuenta);
		//return cuenta.getNumero();
	}


	@Override
	@Async
	//no podemos retornan directamente el string debo apoyarme
	// de una clase llamada Comparable Future
	public CompletableFuture<String> agregarAsincrono2(Cuenta cuenta) {
		LOG.info("HILO: " + Thread.currentThread().getName());

		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		this.cuentaRepo.insertar(cuenta);
		return  CompletableFuture.completedFuture(cuenta.getNumero())  ;
	}


	@Override
	@Async
	public CompletableFuture<Integer> calcularEdad(LocalDate localDate) {
		// TODO Auto-generated method stub
		Period periodo= Period.between(localDate, localDate.now());
		try {
			TimeUnit.SECONDS.sleep(5);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(periodo.getYears());
	}
	


}
