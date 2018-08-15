package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;
import java.util.Date;

public class OrdemServico implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Contrato contrato;
	
	private  TipoOS tipoOS;
	
	private Integer numero;
	
	private Integer ano;
	
	private Date dataAbertura;
	
	private Date dataInicioPeriodo;
	
	private Date dataFimPeriodo;
	
	private Integer qtdDias;
	
	private Integer qtdDiasUteis;
	
	private VigenciaContrato vigenciaContrato;
	
	public OrdemServico() {
	}
	
	public OrdemServico(Integer id) {
		super();
		this.id = id;
	}

	public OrdemServico(Integer id, Contrato contrato, TipoOS tipoOS, Integer numero, Integer ano, Date dataAbertura,
			Date dataInicioPeriodo, Date dataFimPeriodo, Integer qtdDias, Integer qtdDiasUteis,
			VigenciaContrato vigenciaContrato) {
		super();
		this.id = id;
		this.contrato = contrato;
		this.tipoOS = tipoOS;
		this.numero = numero;
		this.ano = ano;
		this.dataAbertura = dataAbertura;
		this.dataInicioPeriodo = dataInicioPeriodo;
		this.dataFimPeriodo = dataFimPeriodo;
		this.qtdDias = qtdDias;
		this.qtdDiasUteis = qtdDiasUteis;
		this.vigenciaContrato = vigenciaContrato;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public TipoOS getTipoOS() {
		return tipoOS;
	}

	public void setTipoOS(TipoOS tipoOS) {
		this.tipoOS = tipoOS;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataInicioPeriodo() {
		return dataInicioPeriodo;
	}

	public void setDataInicioPeriodo(Date dataInicioPeriodo) {
		this.dataInicioPeriodo = dataInicioPeriodo;
	}

	public Date getDataFimPeriodo() {
		return dataFimPeriodo;
	}

	public void setDataFimPeriodo(Date dataFimPeriodo) {
		this.dataFimPeriodo = dataFimPeriodo;
	}

	public Integer getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(Integer qtdDias) {
		this.qtdDias = qtdDias;
	}

	public Integer getQtdDiasUteis() {
		return qtdDiasUteis;
	}

	public void setQtdDiasUteis(Integer qtdDiasUteis) {
		this.qtdDiasUteis = qtdDiasUteis;
	}

	public VigenciaContrato getVigenciaContrato() {
		return vigenciaContrato;
	}

	public void setVigenciaContrato(VigenciaContrato vigenciaContrato) {
		this.vigenciaContrato = vigenciaContrato;
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
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
