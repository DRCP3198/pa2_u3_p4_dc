package com.example.demo.modelo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.modelo.banco.Cuenta;
import com.example.demo.modelo.banco.repo.ICuentaRepo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private ICuentaRepo cuentaRepo;

	@Autowired
	private IPruebaService iPruebaService;

	@Override
	//@Transactional //EL REQUIRED ES POR DEFECTO
	public void agregar(Cuenta cuentaBancaria) {
		// TODO Auto-generated method stub
		System.out.println("Service " + TransactionSynchronizationManager.isActualTransactionActive());
		// this.cuentaRepo.insertar(cuentaBancaria);
		// this.prueba();
		// this.iPruebaService.prueba();
		// this.iPruebaService.prueba2();
		// this.iPruebaService.pruebaSupports();
		// this.iPruebaService.pruebaNotSupported();
        //this.iPruebaService.pruebaRequired();
		this.iPruebaService.pruebaRequiresNew();
	}

	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba");
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
