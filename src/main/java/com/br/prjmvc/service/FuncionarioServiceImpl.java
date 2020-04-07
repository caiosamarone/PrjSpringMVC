package com.br.prjmvc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.prjmvc.dao.FuncionarioDao;
import com.br.prjmvc.domain.Funcionario;
@Service @Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	FuncionarioDao dao;
	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
	}

	@Override
	public void excluir(Long id) {	
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id);
	}
	
	@Override @Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		return dao.findByNome(nome);
	}

	@Override
	public List<Funcionario> buscarPorCargo(String cargo) {
		return dao.findByCargo(cargo);
	}

	@Override
	public List<Funcionario> buscarPorData(LocalDate entrada, LocalDate saida) {
		
		if(entrada != null && saida != null) {
			return dao.findByEntradaSaida(entrada,saida);
		} else if(entrada != null) {
			return dao.findByEntrada(entrada);
		}else if(saida != null) {
			return dao.findBySaida(saida);
		}else {
			return new ArrayList<>();
		}
	}
	
	
}
