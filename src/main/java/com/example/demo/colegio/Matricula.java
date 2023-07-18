package com.example.demo.colegio;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@SequenceGenerator(name = "seq_matr", sequenceName = "seq_matr", allocationSize = 1)
	@GeneratedValue(generator = "seq_matr", strategy = GenerationType.SEQUENCE)
	@Column(name = "matr_id")
	private Integer id;

	@Column(name = "matr_tipo")
	private String tipo;

	@Column(name = "matr_numero_créditos")
	private String numCreditos;

	@Column(name = "matr_fecha")
	private LocalDate fecha;

	@ManyToOne
	@JoinColumn(name = "matr_id_estu")
	private Estudiante estudiante;

	@ManyToOne
	@JoinColumn(name = "matr_id_materia")
	private Materia materia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumCreditos() {
		return numCreditos;
	}

	public void setNumCreditos(String numCreditos) {
		this.numCreditos = numCreditos;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", tipo=" + tipo + ", numCreditos=" + numCreditos + ", fecha=" + fecha + "]";
	}

}
