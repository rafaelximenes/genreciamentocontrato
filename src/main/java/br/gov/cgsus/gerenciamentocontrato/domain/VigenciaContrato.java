package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;
import java.util.Date;

public class VigenciaContrato implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Contrato contrato;
	
	private Date inicioVigencia;
	
	private Date terminoVigencia;
	
	public VigenciaContrato() {
		
	}
	
	public VigenciaContrato(Integer id) {
		this.id = id;
	}

	public VigenciaContrato(Integer id, Contrato contrato, Date inicioVigencia, Date terminoVigencia) {
		super();
		this.id = id;
		this.contrato = contrato;
		this.inicioVigencia = inicioVigencia;
		this.terminoVigencia = terminoVigencia;
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

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Date getTerminoVigencia() {
		return terminoVigencia;
	}

	public void setTerminoVigencia(Date terminoVigencia) {
		this.terminoVigencia = terminoVigencia;
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
		VigenciaContrato other = (VigenciaContrato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
