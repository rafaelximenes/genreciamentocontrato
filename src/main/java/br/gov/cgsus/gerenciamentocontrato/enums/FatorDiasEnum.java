package br.gov.cgsus.gerenciamentocontrato.enums;

public enum FatorDiasEnum {
	
	HORAS_12(12,"12 Horas"),
	HORAS_24(24,"24 Horas");
	
	private Integer cod;
	
	private String descricao;
	
	FatorDiasEnum(Integer id, String descricao) {
		this.cod = id;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
