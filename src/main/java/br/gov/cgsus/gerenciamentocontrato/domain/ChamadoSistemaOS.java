package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;
import java.util.Date;

public class ChamadoSistemaOS implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private SistemaOS sistemaOS;
	
	private String descricao;
	
	private Date abertura;
	
	private Date inicioAtendimento;
	
	private Date fimAtendimento;
	
	private Integer atraso;
	
	private TipoAceite tipoAceite;
	
	private Integer qtdDiasAtrasoProduto;
	
	private Double coberturaTesteApurado;
	
	private String status;
	
	public ChamadoSistemaOS() {
	}
	
	public ChamadoSistemaOS(Integer id) {
		super();
		this.id = id;
	}
	
	public ChamadoSistemaOS(Integer id, String descricao, Date abertura, Date inicioAtendimento, Date fimAtendimento,
			Integer atraso, TipoAceite tipoAceite, Integer qtdDiasAtrasoProduto, Double coberturaTesteApurado,
			String status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.abertura = abertura;
		this.inicioAtendimento = inicioAtendimento;
		this.fimAtendimento = fimAtendimento;
		this.atraso = atraso;
		this.tipoAceite = tipoAceite;
		this.qtdDiasAtrasoProduto = qtdDiasAtrasoProduto;
		this.coberturaTesteApurado = coberturaTesteApurado;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getAbertura() {
		return abertura;
	}

	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}

	public Date getInicioAtendimento() {
		return inicioAtendimento;
	}

	public void setInicioAtendimento(Date inicioAtendimento) {
		this.inicioAtendimento = inicioAtendimento;
	}

	public Date getFimAtendimento() {
		return fimAtendimento;
	}

	public void setFimAtendimento(Date fimAtendimento) {
		this.fimAtendimento = fimAtendimento;
	}

	public Integer getAtraso() {
		return atraso;
	}

	public void setAtraso(Integer atraso) {
		this.atraso = atraso;
	}

	public TipoAceite getTipoAceite() {
		return tipoAceite;
	}

	public void setTipoAceite(TipoAceite tipoAceite) {
		this.tipoAceite = tipoAceite;
	}

	public Integer getQtdDiasAtrasoProduto() {
		return qtdDiasAtrasoProduto;
	}

	public void setQtdDiasAtrasoProduto(Integer qtdDiasAtrasoProduto) {
		this.qtdDiasAtrasoProduto = qtdDiasAtrasoProduto;
	}

	public Double getCoberturaTesteApurado() {
		return coberturaTesteApurado;
	}

	public void setCoberturaTesteApurado(Double coberturaTesteApurado) {
		this.coberturaTesteApurado = coberturaTesteApurado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public SistemaOS getSistemaOS() {
		return sistemaOS;
	}

	public void setSistemaOS(SistemaOS sistemaOS) {
		this.sistemaOS = sistemaOS;
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
		ChamadoSistemaOS other = (ChamadoSistemaOS) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
