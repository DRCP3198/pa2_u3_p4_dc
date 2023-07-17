package com.example.demo.modelo.banco.service;

import com.example.demo.modelo.banco.Cuenta;


public interface ICuentaService {
	
	public void agregar(Cuenta cuentaBancaria);

	public Cuenta encontrarPorId(Integer id);

	public void modificar(Cuenta cuentaBancaria);

}
