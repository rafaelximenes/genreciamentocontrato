package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class UsuarioContrato implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	private Contrato contrato;
	
	private Perfil perfil;

	public UsuarioContrato() {
		
	}
	
	public UsuarioContrato(Usuario usuario, Contrato contrato, Perfil perfil) {
		super();
		this.usuario = usuario;
		this.contrato = contrato;
		this.perfil = perfil;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	

}
