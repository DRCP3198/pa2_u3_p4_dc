package com.example.demo.colegio;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private Integer nombre;

	@Column(name = "prov_capital")
	private Integer capital;

	@Column(name = "prov_cod_postal")
	private Integer codPostal;

	@OneToMany(mappedBy = "provinvia",cascade = CascadeType.ALL)
	private List<Estudiante> estudiante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public Integer getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(Integer codPostal) {
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
