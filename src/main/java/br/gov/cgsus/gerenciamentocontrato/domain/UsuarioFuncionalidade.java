package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class UsuarioFuncionalidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Perfil perfil;
	
	private Funcionalidade funcionalidade;

	public UsuarioFuncionalidade(Perfil perfil, Funcionalidade funcionalidade) {
		super();
		this.perfil = perfil;
		this.funcionalidade = funcionalidade;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}
	
	

}
