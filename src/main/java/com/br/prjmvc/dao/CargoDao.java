package com.br.prjmvc.dao;

import java.util.List;

import com.br.prjmvc.domain.Cargo;

public interface CargoDao {
void save(Cargo cargo);
	
	void update(Cargo cargo);
	
	void delete(Long id);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();
}
