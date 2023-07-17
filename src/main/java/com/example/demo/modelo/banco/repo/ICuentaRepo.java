package com.example.demo.modelo.banco.repo;

import com.example.demo.modelo.banco.Cuenta;

public interface ICuentaRepo {
	
	public void insertar(Cuenta cuentaBancaria);

	public Cuenta seleccionarPorId(Integer id);

	public void actualizar(Cuenta cuentaBancaria);
}
