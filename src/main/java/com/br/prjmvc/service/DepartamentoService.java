package com.br.prjmvc.service;

import java.util.List;


import com.br.prjmvc.domain.Departamento;

public interface DepartamentoService {

	void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos();

	boolean temCargo(Long id);
}
