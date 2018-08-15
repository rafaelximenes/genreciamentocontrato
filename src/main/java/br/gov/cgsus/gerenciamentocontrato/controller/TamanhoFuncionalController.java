package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.Sistema;
import br.gov.cgsus.gerenciamentocontrato.domain.TamanhoFuncional;
import br.gov.cgsus.gerenciamentocontrato.service.SistemaBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.TamanhoFuncionalBusiness;

@ManagedBean
@ViewScoped
public class TamanhoFuncionalController extends Controller {

	private TamanhoFuncional tamanhoFuncional;
	
	private List<TamanhoFuncional> listaTamanhoFuncionales;
	
	private List<TamanhoFuncional> listaFiltrada;
	
	private List<Sistema> listaSistemas;
	
	private TamanhoFuncionalBusiness tamanhoFuncionalBusiness;
	
	@PostConstruct
	public void inicializar() {
		tamanhoFuncionalBusiness = new TamanhoFuncionalBusiness();
		tamanhoFuncional = new TamanhoFuncional();
		pesquisar();
		populaCombo();
	}
	
	private void populaCombo() {
		SistemaBusiness sistemaBusiness = new SistemaBusiness();
		try {
			listaSistemas = sistemaBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}

	public void cadastrar() {
		try {
			tamanhoFuncionalBusiness.inserir(tamanhoFuncional);
			jsfInfo("TamanhoFuncional cadastrado com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	public void pesquisar() {
		try {
			listaTamanhoFuncionales = tamanhoFuncionalBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public void limparDados() {
		inicializar();
	}

	public TamanhoFuncional getTamanhoFuncional() {
		return tamanhoFuncional;
	}

	public void setTamanhoFuncional(TamanhoFuncional tamanhoFuncional) {
		this.tamanhoFuncional = tamanhoFuncional;
	}

	public List<TamanhoFuncional> getListaTamanhoFuncionales() {
		return listaTamanhoFuncionales;
	}

	public void setListaTamanhoFuncionales(List<TamanhoFuncional> listaTamanhoFuncionales) {
		this.listaTamanhoFuncionales = listaTamanhoFuncionales;
	}

	public List<TamanhoFuncional> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<TamanhoFuncional> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public List<Sistema> getListaSistemas() {
		return listaSistemas;
	}

	public void setListaSistemas(List<Sistema> listaSistemas) {
		this.listaSistemas = listaSistemas;
	}

	
}
