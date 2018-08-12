package br.gov.cgsus.gerenciamentocontrato.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.dao.FornecedorDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Fornecedor;

@ManagedBean
@ViewScoped
public class FornecedorController {

	private Fornecedor fornecedor;
	
	@PostConstruct
	public void inicializar() {
		fornecedor = new Fornecedor();
	}
	
	public void cadastrar() {
		FornecedorDao fornecedorDao = new FornecedorDao();
		fornecedorDao.inserir(fornecedor);
		
	}
	
	public void limparDados() {
		inicializar();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	
}
