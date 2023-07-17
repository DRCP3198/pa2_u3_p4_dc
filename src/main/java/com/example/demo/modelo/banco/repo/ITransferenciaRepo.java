package com.example.demo.modelo.banco.repo;

import java.util.List;

import com.example.demo.modelo.banco.Transferencia;

public interface ITransferenciaRepo {

	public void insertar(Transferencia transferencia);

	public List<Transferencia> seleccionarTodos();

}
