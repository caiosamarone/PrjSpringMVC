package com.br.prjmvc.dao;

import java.time.LocalDate;
import java.util.List;


import com.br.prjmvc.domain.Funcionario;

public interface FuncionarioDao {
	
	void save(Funcionario funcionario);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();

	List<Funcionario> findByNome(String nome);

	List<Funcionario> findByCargo(String cargo);

	List<Funcionario> findByEntradaSaida(LocalDate entrada, LocalDate saida);

	List<Funcionario> findByEntrada(LocalDate entrada);

	List<Funcionario> findBySaida(LocalDate saida);
}
