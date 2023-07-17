package com.example.demo.modelo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.banco.Cuenta;
import com.example.demo.modelo.banco.Transferencia;
import com.example.demo.modelo.banco.repo.ICuentaRepo;
import com.example.demo.modelo.banco.repo.ITransferenciaRepo;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
	
	@Autowired
	private ITransferenciaRepo iTransferenciaRepo;
	
	@Autowired
	private ICuentaRepo cuentaRepo;

	@Override
	public void agregar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepo.insertar(transferencia);
	}

	@Override
	public void transferir(Integer idCuentaOrigen, Integer idCuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		Cuenta origen = this.cuentaRepo.seleccionarPorId(idCuentaOrigen);
		Cuenta destino=this.cuentaRepo.seleccionarPorId(idCuentaDestino);
		
		Transferencia trasf= new Transferencia();
		trasf.setFecha(LocalDateTime.now());
		trasf.setCuentaOrigen(origen);
		trasf.setCuentaDestino(destino);
		trasf.setMonto(monto);
		
		if(monto.compareTo(origen.getSaldo())<=0) {
			origen.setSaldo(origen.getSaldo().subtract(monto));
			destino.setSaldo(destino.getSaldo().add(monto));
			this.cuentaRepo.actualizar(origen);
			this.cuentaRepo.actualizar(destino);
		}else {
			System.out.println("Saldo no disponible para el monto ingresado: " + monto);
		}
		
		this.iTransferenciaRepo.insertar(trasf);
		
		
		
	}

	@Override
	public List<Transferencia> reporte() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepo.seleccionarTodos();
	}
	
	

}
