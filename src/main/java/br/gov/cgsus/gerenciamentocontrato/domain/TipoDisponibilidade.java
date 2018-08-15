package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class TipoDisponibilidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private boolean diasCorridos; 
	
	private Integer fatorHoras;
	
	private String descricaoFatorHoras;
	
	public TipoDisponibilidade() {
	}
	
	public TipoDisponibilidade(Integer id) {
		super();
		this.id = id;
	}

	public TipoDisponibilidade(Integer id, String nome, String descricao, boolean diasCorridos, Integer fatorHoras) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.diasCorridos = diasCorridos;
		this.fatorHoras = fatorHoras;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isDiasCorridos() {
		return diasCorridos;
	}

	public void setDiasCorridos(boolean diasCorridos) {
		this.diasCorridos = diasCorridos;
	}

	public Integer getFatorHoras() {
		return fatorHoras;
	}

	public void setFatorHoras(Integer fatorHoras) {
		this.fatorHoras = fatorHoras;
	}
	
	public String getDiasCorridosFormato() {
		if(diasCorridos)
			return "Dias Corridos";
		else
			return "Dias Úteis";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoDisponibilidade other = (TipoDisponibilidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getDescricaoFatorHoras() {
		return descricaoFatorHoras;
	}

	public void setDescricaoFatorHoras(String descricaoFatorHoras) {
		this.descricaoFatorHoras = descricaoFatorHoras;
	}
	
	

}
