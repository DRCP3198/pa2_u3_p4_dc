package com.example.demo.modelo.banco.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.modelo.banco.Transferencia;

public interface ITransferenciaService {
	
	
	public void agregar(Transferencia transferencia);

	public void transferir(Integer idCuentaOrigen,Integer idCuentaDestino,BigDecimal monto);
	public List<Transferencia> reporte();


}
