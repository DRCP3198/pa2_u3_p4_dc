package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transferencia {
	
	
	private Integer id;
	private LocalDateTime fecha;
	private BigDecimal monto;
	
	private Cuenta origen;
	private Cuenta destino;
	
	
	@Override
	public String toString() {
		return "Transferencia [numero=" + numero + ", monto=" + monto + ", fecha=" + fecha + ", origen=" + origen
				+ ", destino=" + destino + "]";
	}
	//SET y GET
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Cuenta getOrigen() {
		return origen;
	}
	public void setOrigen(Cuenta origen) {
		this.origen = origen;
	}
	public Cuenta getDestino() {
		return destino;
	}
	public void setDestino(Cuenta destino) {
		this.destino = destino;
	}
	

}
