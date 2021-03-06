package com.br.prjmvc.service;

import java.util.List;

import com.br.prjmvc.domain.Cargo;
import com.br.prjmvc.util.PaginacaoUtil;

public interface CargoService {
	

	
	void salvar(Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();

	boolean temFuncionario(Long id);
	
	PaginacaoUtil<Cargo> buscaPaginada(int pagina, String direcao);
}
