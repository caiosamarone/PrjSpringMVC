package com.br.prjmvc.domain;

public enum UF {
	AC("AC", "Acre"), 
	AL("AL", "Alagoas"),
	AM("AM", "Amazonas"),
	BA("BA", "Bahia"),
	CE("CE", "CearÃ¡"),
	DF("DF", "Distrito Federal"),
	ES("ES", "EspÃ­rito Santo"),
	GO("GO", "GoiÃ¡s"),
	MA("MA", "MaranhÃ£o"),
	MT("MT", "Mato Grosso"),
	MS("MS", "Mato Grosso do Sul"),
	MG("MG", "Minas Gerais"),
	PA("PA", "ParÃ¡"),
	PB("PB", "ParaÃ­ba"),
	PR("PR", "ParanÃ¡"),
	PE("PE", "Pernambuco"),
	PI("PI", "PiauÃ­"),
	RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"),
	RS("RS", "Rio Grande do Sul"),
	RO("RO", "RondÃ´nia"),
	RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"),
	SP("SP", "SÃ£o Paulo"),
	SE("SE", "Sergipe"),
	TO("TO", "Tocantins");
			
	private String sigla;
	private String descricao;
	
	private UF(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
