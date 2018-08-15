package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class NivelCriticidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	
	private Integer tempoIndisponibilidade;
	
	private Double fatorCriticidade;
	
	public NivelCriticidade() {
	}
	
	public NivelCriticidade(Integer id) {
		this.id = id;
	}
	
	public NivelCriticidade(Integer id, String nome, Integer tempoIndisponibilidade, Double fatorCriticidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.tempoIndisponibilidade = tempoIndisponibilidade;
		this.fatorCriticidade = fatorCriticidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTempoIndisponibilidade() {
		return tempoIndisponibilidade;
	}

	public void setTempoIndisponibilidade(Integer tempoIndisponibilidade) {
		this.tempoIndisponibilidade = tempoIndisponibilidade;
	}

	public Double getFatorCriticidade() {
		return fatorCriticidade;
	}

	public void setFatorCriticidade(Double fatorCriticidade) {
		this.fatorCriticidade = fatorCriticidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		NivelCriticidade other = (NivelCriticidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
