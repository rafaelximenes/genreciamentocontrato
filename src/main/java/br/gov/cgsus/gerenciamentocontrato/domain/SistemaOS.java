package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class SistemaOS implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private OrdemServico ordemServico;
	
	private Sistema sistema;
	
	private Double coberturaTeste;
	
	private NivelCriticidade nivelCriticidade;
	
	private TipoDisponibilidade tipoDisponibilidade;
	
	private Double percentualDisponibilidade;
	
	private Double qtdhoraSustentada;
	
	private Double fatorPFS;
	
	private Double qtdPFS;
	
	private Double valorUnitarioPFS;
	
	private Double disponibilidadeApurada;
	
	private Integer tamanhoPF;
	
	private Integer novoTamanhoPF;
	

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Double getCoberturaTeste() {
		return coberturaTeste;
	}

	public void setCoberturaTeste(Double coberturaTeste) {
		this.coberturaTeste = coberturaTeste;
	}

	public NivelCriticidade getNivelCriticidade() {
		return nivelCriticidade;
	}

	public void setNivelCriticidade(NivelCriticidade nivelCriticidade) {
		this.nivelCriticidade = nivelCriticidade;
	}

	public TipoDisponibilidade getTipoDisponibilidade() {
		return tipoDisponibilidade;
	}

	public void setTipoDisponibilidade(TipoDisponibilidade tipoDisponibilidade) {
		this.tipoDisponibilidade = tipoDisponibilidade;
	}

	public Double getPercentualDisponibilidade() {
		return percentualDisponibilidade;
	}

	public void setPercentualDisponibilidade(Double percentualDisponibilidade) {
		this.percentualDisponibilidade = percentualDisponibilidade;
	}

	public Double getQtdhoraSustentada() {
		return qtdhoraSustentada;
	}

	public void setQtdhoraSustentada(Double qtdhoraSustentada) {
		this.qtdhoraSustentada = qtdhoraSustentada;
	}

	public Double getFatorPFS() {
		return fatorPFS;
	}

	public void setFatorPFS(Double fatorPFS) {
		this.fatorPFS = fatorPFS;
	}

	public Double getQtdPFS() {
		return qtdPFS;
	}

	public void setQtdPFS(Double qtdPFS) {
		this.qtdPFS = qtdPFS;
	}

	public Double getValorUnitarioPFS() {
		return valorUnitarioPFS;
	}

	public void setValorUnitarioPFS(Double valorUnitarioPFS) {
		this.valorUnitarioPFS = valorUnitarioPFS;
	}

	public Double getDisponibilidadeApurada() {
		return disponibilidadeApurada;
	}

	public void setDisponibilidadeApurada(Double disponibilidadeApurada) {
		this.disponibilidadeApurada = disponibilidadeApurada;
	}

	public Integer getNovoTamanhoPF() {
		return novoTamanhoPF;
	}

	public void setNovoTamanhoPF(Integer novoTamanhoPF) {
		this.novoTamanhoPF = novoTamanhoPF;
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
		SistemaOS other = (SistemaOS) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getTamanhoPF() {
		return tamanhoPF;
	}

	public void setTamanhoPF(Integer tamanhoPF) {
		this.tamanhoPF = tamanhoPF;
	}
	
}
