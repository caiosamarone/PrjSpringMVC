package com.br.prjmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.br.prjmvc.domain.Cargo;
import com.br.prjmvc.util.PaginacaoUtil;


@Repository
public class CargoDaoImpl extends AbstractDao<Cargo,Long> implements CargoDao {
	
	@Override
	public PaginacaoUtil<Cargo> buscaPaginada(int pagina, String direcao){
		int tamanho = 5;
		int inicio = (pagina - 1) * tamanho	;
		long totalRegistros;
		long totalDePaginas;
		List<Cargo> cargos = getEntityManager()
				.createQuery("select c from Cargo c order by c.nome " + direcao,Cargo.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		totalRegistros = count();
		totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;
		
		return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas,cargos,direcao);
	}
	
	public long count() {
		return getEntityManager().createQuery("select count(*) from Cargo",Long.class).getSingleResult();
	}

	

}
