package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.colegio.Estudiante;
import com.example.demo.colegio.Materia;
import com.example.demo.colegio.Provincia;
import com.example.demo.colegio.Semestre;
import com.example.demo.colegio.service.IEstudianteService;
import com.example.demo.colegio.service.IMateriaService;
import com.example.demo.colegio.service.IMatriculaService;
import com.example.demo.modelo.banco.Cuenta;
import com.example.demo.modelo.banco.Propietario;
import com.example.demo.modelo.banco.Transferencia;
import com.example.demo.modelo.banco.service.ICuentaService;
import com.example.demo.modelo.banco.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4DcApplication implements CommandLineRunner {

	@Autowired
	private ICuentaService cuentaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        
		//No dice si esta una transaccion activa
		TransactionSynchronizationManager.isActualTransactionActive();
		System.out.println("Main " +TransactionSynchronizationManager.isActualTransactionActive());
        
		Cuenta cuenta= new Cuenta();
        cuenta.setNumero("13313");
        cuenta.setSaldo(new BigDecimal(200));
        cuenta.setTipo("A");
        
		this.cuentaService.agregar(cuenta);
	}

}
