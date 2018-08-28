package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;

public class Funcionalidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nome;

	public Funcionalidade(Integer id, String nome) {
		super();
		this.setId(id);
		this.nome = nome;
	}
	
	public Funcionalidade() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
