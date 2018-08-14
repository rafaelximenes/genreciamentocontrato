package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class MetricaVigencia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private VigenciaContrato vigenciaContrato;
	
	private Metrica metrica;
	
	private Integer qtdMetrica;
	
	private Double valorMetrica;
	
	public MetricaVigencia() {
	}

	public MetricaVigencia(Integer id, VigenciaContrato vigenciaContrato, Metrica metrica, Integer qtdMetrica,
			Double valorMetrica) {
		super();
		this.id = id;
		this.vigenciaContrato = vigenciaContrato;
		this.metrica = metrica;
		this.qtdMetrica = qtdMetrica;
		this.valorMetrica = valorMetrica;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VigenciaContrato getVigenciaContrato() {
		return vigenciaContrato;
	}

	public void setVigenciaContrato(VigenciaContrato vigenciaContrato) {
		this.vigenciaContrato = vigenciaContrato;
	}

	public Metrica getMetrica() {
		return metrica;
	}

	public void setMetrica(Metrica metrica) {
		this.metrica = metrica;
	}

	public Integer getQtdMetrica() {
		return qtdMetrica;
	}

	public void setQtdMetrica(Integer qtdMetrica) {
		this.qtdMetrica = qtdMetrica;
	}

	public Double getValorMetrica() {
		return valorMetrica;
	}

	public void setValorMetrica(Double valorMetrica) {
		this.valorMetrica = valorMetrica;
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
		MetricaVigencia other = (MetricaVigencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
