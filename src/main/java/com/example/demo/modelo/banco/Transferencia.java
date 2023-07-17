package com.example.demo.modelo.banco;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="transferencia")
public class Transferencia {
	
	@Id
	@SequenceGenerator(name = "seq_transf",sequenceName = "seq_transf",allocationSize = 1)
	@GeneratedValue(generator = "seq_transf",strategy = GenerationType.SEQUENCE)
	@Column(name = "transf_id")
	private Integer id;
	
	@Column(name = "transf_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "transf_monto")
	private BigDecimal monto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transf_cuentaOrigen_cta")
	private Cuenta cuentaOrigen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transf_cuentaDestino_cta")
	private Cuenta cuentaDestino;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", monto=" + monto + "]";
	}
	

	
	
	
	

}
