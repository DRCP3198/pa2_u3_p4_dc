package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.banco.Cuenta;
import com.example.demo.modelo.banco.Propietario;
import com.example.demo.modelo.banco.Transferencia;
import com.example.demo.modelo.banco.service.ICuentaService;
import com.example.demo.modelo.banco.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4DcApplication implements CommandLineRunner {
	

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
		
		Propietario p = new Propietario();
		p.setNombre("Henry");
		p.setApellido("Coyago");
		p.setCedula("1725247699");
		List<Cuenta> listaCuenta = new ArrayList<>();
		
		Cuenta cuentaOrigen = new Cuenta();
		cuentaOrigen.setNumero("123345");
		cuentaOrigen.setPropietario(p);
		cuentaOrigen.setSaldo(new BigDecimal(4000));
		cuentaOrigen.setTipo("A");

		
		Cuenta cuentaDestino = new Cuenta();
		cuentaDestino.setNumero("0987656");
		cuentaDestino.setSaldo(new BigDecimal(1000));
		cuentaDestino.setTipo("A");
		cuentaDestino.setPropietario(p);
		
		
		listaCuenta.add(cuentaOrigen);
	    listaCuenta.add(cuentaDestino);
		p.setCuentas(listaCuenta);
		
		//this.iCuentaBancariaService.agregar(cuentaOrigen);
		//this.iCuentaBancariaService.agregar(cuentaDestino);
		
	    //this.iTransferenciaService.transferir(12, 13, new BigDecimal(3000));
		List<Transferencia> reporte= this.iTransferenciaService.reporte();
		for (Transferencia transferencia : reporte) {
			System.out.println(transferencia);
		}
		

	}

}
