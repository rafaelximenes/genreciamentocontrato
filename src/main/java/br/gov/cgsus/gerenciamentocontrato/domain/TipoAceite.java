package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class TipoAceite implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String tipoAceite;
	
	private Integer peso;

	public TipoAceite() {
	}
	
	public TipoAceite(Integer id) {
		super();
		this.id = id;
	}

	public TipoAceite(Integer id, String tipoAceite, Integer peso) {
		super();
		this.id = id;
		this.tipoAceite = tipoAceite;
		this.peso = peso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoAceite() {
		return tipoAceite;
	}

	public void setTipoAceite(String tipoAceite) {
		this.tipoAceite = tipoAceite;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
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
		TipoAceite other = (TipoAceite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
