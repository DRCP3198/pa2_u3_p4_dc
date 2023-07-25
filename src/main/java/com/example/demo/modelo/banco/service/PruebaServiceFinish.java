package com.example.demo.modelo.banco.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PruebaServiceFinish implements IPruebaService{

	@Override
	@Transactional(value =  TxType.NEVER)
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println("metodo1 " +TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método de prueba");
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba2() {
		// TODO Auto-generated method stub
		System.out.println("metodo2 "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método de prueba2");
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método de Supports");
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaNotSupported() {
		// TODO Auto-generated method stub
		System.out.println("metodo not_supported "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método de Not Supported");
		
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void pruebaRequired() {
		// TODO Auto-generated method stub
		System.out.println("metodo required "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método required");
		
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaRequiresNew() {
		// TODO Auto-generated method stub
		System.out.println("metodo requires new "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método requires new");
		
		
	}

}
