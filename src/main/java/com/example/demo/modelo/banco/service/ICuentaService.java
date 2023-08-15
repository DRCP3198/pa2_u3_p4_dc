package com.example.demo.modelo.banco.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import com.example.demo.modelo.banco.Cuenta;

public interface ICuentaService {

	public void agregar(Cuenta cuentaBancaria);

	public Cuenta encontrarPorId(Integer id);

	public void modificar(Cuenta cuentaBancaria);

	public String agregar2(Cuenta bancaria);

	public void agregarAsincrono(Cuenta cuenta);

	public CompletableFuture<String> agregarAsincrono2(Cuenta cuenta);
	
	public CompletableFuture<Integer>  calcularEdad(LocalDate localDate);

}
