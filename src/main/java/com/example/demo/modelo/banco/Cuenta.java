package com.example.demo.modelo.banco;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta {
	
	@Id
	@SequenceGenerator(name = "seq_cta",sequenceName = "seq_cta",allocationSize = 1)
	@GeneratedValue(generator = "seq_cta",strategy = GenerationType.SEQUENCE)
	@Column(name = "cta_id")
	private Integer id;
	
	@Column(name = "cta_numer")
	private String numero;
	
	@Column(name = "cta_saldo")
	private BigDecimal saldo; //siempre para temas monetarios
	
	@Column(name = "cta_tipo")
	private String tipo;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cta_id_prop")
    private Propietario propietario;
    
    @OneToMany(mappedBy = "cuentaOrigen",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transferencia> trasferenciaOrigen;
    
    @OneToMany(mappedBy = "cuentaDestino",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transferencia> trasferenciaDestino;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	public List<Transferencia> getTrasferenciaOrigen() {
		return trasferenciaOrigen;
	}

	public void setTrasferenciaOrigen(List<Transferencia> trasferenciaOrigen) {
		this.trasferenciaOrigen = trasferenciaOrigen;
	}

	public List<Transferencia> getTrasferenciaDestino() {
		return trasferenciaDestino;
	}

	public void setTrasferenciaDestino(List<Transferencia> trasferenciaDestino) {
		this.trasferenciaDestino = trasferenciaDestino;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}


	
	

	

	
}
