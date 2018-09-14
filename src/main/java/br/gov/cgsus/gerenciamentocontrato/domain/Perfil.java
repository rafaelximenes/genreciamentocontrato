package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class Perfil implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	
	public Perfil(Integer id) {
		this.id = id;
	}
	
	public Perfil(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Perfil() {
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

	
	
	

}
