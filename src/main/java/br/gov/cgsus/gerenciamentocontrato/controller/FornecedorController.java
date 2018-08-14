package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.Fornecedor;
import br.gov.cgsus.gerenciamentocontrato.service.FornecedorBusiness;

@ManagedBean
@ViewScoped
public class FornecedorController extends Controller {

	private Fornecedor fornecedor;
	
	private List<Fornecedor> listaFornecedores;
	
	private List<Fornecedor> listaFiltrada;
	
	private FornecedorBusiness fornecedorBusiness;
	
	@PostConstruct
	public void inicializar() {
		fornecedorBusiness = new FornecedorBusiness();
		fornecedor = new Fornecedor();
		pesquisar();
	}
	
	public void cadastrar() {
		try {
			fornecedorBusiness.inserir(fornecedor);
			jsfInfo("Fornecedor cadastrado com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	public void pesquisar() {
		try {
			listaFornecedores = fornecedorBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
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

	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	public List<Fornecedor> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Fornecedor> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	
}
