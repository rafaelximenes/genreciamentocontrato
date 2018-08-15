package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class Sistema implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	
	private boolean ativo;
	
	public Sistema() {
	}
	
	public Sistema(Integer id) {
		super();
		this.id = id;
		
	}

	public Sistema(Integer id, String nome, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getAtivoFormatado() {
		if(ativo)
			return "Sim";
		return "Não";
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
		Sistema other = (Sistema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
