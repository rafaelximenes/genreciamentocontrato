package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class TipoOS implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	
	private boolean flagSustentacao;
	
	private Metrica metrica;
	
	
	public TipoOS() {
	}
	
	public TipoOS(Integer id) {
		this.id = id;
	}

	public TipoOS(Integer id, String nome, boolean flagSustentacao, Metrica metrica) {
		super();
		this.id = id;
		this.nome = nome;
		this.flagSustentacao = flagSustentacao;
		this.metrica = metrica;
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

	public boolean isFlagSustentacao() {
		return flagSustentacao;
	}

	public void setFlagSustentacao(boolean flagSustentacao) {
		this.flagSustentacao = flagSustentacao;
	}

	public Metrica getMetrica() {
		return metrica;
	}

	public void setMetrica(Metrica metrica) {
		this.metrica = metrica;
	}
	
	public String getSustentacaoFormatado() {
		if(flagSustentacao) {
			return "Sim";
		} else {
			return "Não";
		}
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
		TipoOS other = (TipoOS) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}