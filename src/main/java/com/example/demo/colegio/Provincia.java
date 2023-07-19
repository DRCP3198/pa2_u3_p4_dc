package com.example.demo.colegio;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {

	@Id
	@SequenceGenerator(name = "seq_prov", sequenceName = "seq_prov", allocationSize = 1)
	@GeneratedValue(generator = "seq_prov", strategy = GenerationType.SEQUENCE)
	@Column(name = "prov_id")
	private Integer id;

	@Column(name = "prov_nombre")
	private String nombre;

	@Column(name = "prov_capital")
	private String capital;

	@Column(name = "prov_cod_postal")
	private String codPostal;

	@OneToMany(mappedBy = "provinvia")
	private List<Estudiante> estudiante;
     
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}


	public String getCodPostal() {
		return codPostal;
	}


	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}


	public List<Estudiante> getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(List<Estudiante> estudiante) {
		this.estudiante = estudiante;
	}


	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ", capital=" + capital + ", codPostal=" + codPostal + "]";
	}

}
