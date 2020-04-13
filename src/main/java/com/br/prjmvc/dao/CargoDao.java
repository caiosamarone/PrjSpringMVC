package com.br.prjmvc.dao;

import java.util.List;

import com.br.prjmvc.domain.Cargo;
import com.br.prjmvc.util.PaginacaoUtil;

public interface CargoDao {
void save(Cargo cargo);
	
	void update(Cargo cargo);
	
	void delete(Long id);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();
	
	public PaginacaoUtil<Cargo> buscaPaginada(int pagina, String direcao);
}
