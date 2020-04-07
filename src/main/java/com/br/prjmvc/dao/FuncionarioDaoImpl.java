package com.br.prjmvc.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.br.prjmvc.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario,Long> implements FuncionarioDao {

	@Override
	public List<Funcionario> findByNome(String nome) {
		
	/*	criei um metodo createQuery genérico no DAO para facilitar
	  TypedQuery<Funcionario> query = getEntityManager()
				.createQuery("select f from Funcionario f where f.nome like :nome", Funcionario.class);	
		query.setParameter("nome", nome);
		return query.getResultList();
	*/
		
		return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%') ",nome);
	}

	@Override
	public List<Funcionario> findByCargo(String cargo) {
		// TODO Auto-generated method stub
		return createQuery("select f from Funcionario f where f.cargo like concat('%',?1,'%') ",cargo);
	}

	@Override
	public List<Funcionario> findByEntradaSaida(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("select f from Funcionario f ")
					.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
					.append("order by f.dataEntrada asc")
					.toString();
		return createQuery(jpql, entrada,saida);
	}

	@Override
	public List<Funcionario> findByEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("select f from Funcionario f where f.dataEntrada = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		
		return createQuery(jpql, entrada);
		
	}

	@Override
	public List<Funcionario> findBySaida(LocalDate saida) {
		String jpql = new StringBuilder("select f from Funcionario f where f.dataSaida = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		
		return createQuery(jpql, saida);
	}

}
