package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;
import java.util.Date;

public class TamanhoFuncional implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Sistema sistema;
	
	private Date dataVigencia;
	
	private Integer tamanhoPontoFuncao;
	
	public TamanhoFuncional() {
	}
	
	public TamanhoFuncional(Sistema sistema, Date dataVigencia, Integer tamanhoPontoFuncao) {
		super();
		this.sistema = sistema;
		this.dataVigencia = dataVigencia;
		this.tamanhoPontoFuncao = tamanhoPontoFuncao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public Integer getTamanhoPontoFuncao() {
		return tamanhoPontoFuncao;
	}

	public void setTamanhoPontoFuncao(Integer tamanhoPontoFuncao) {
		this.tamanhoPontoFuncao = tamanhoPontoFuncao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataVigencia == null) ? 0 : dataVigencia.hashCode());
		result = prime * result + ((sistema == null) ? 0 : sistema.hashCode());
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
		TamanhoFuncional other = (TamanhoFuncional) obj;
		if (dataVigencia == null) {
			if (other.dataVigencia != null)
				return false;
		} else if (!dataVigencia.equals(other.dataVigencia))
			return false;
		if (sistema == null) {
			if (other.sistema != null)
				return false;
		} else if (!sistema.equals(other.sistema))
			return false;
		return true;
	}
	
}
