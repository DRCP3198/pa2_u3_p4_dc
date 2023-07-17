package com.example.demo.modelo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.banco.Cuenta;
import com.example.demo.modelo.banco.repo.ICuentaRepo;

@Service 
public class CuentaServiceImpl implements ICuentaService{
	
	@Autowired
	private ICuentaRepo cuentaRepo;

	@Override
	public void agregar(Cuenta cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaRepo.insertar(cuentaBancaria);
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

}
