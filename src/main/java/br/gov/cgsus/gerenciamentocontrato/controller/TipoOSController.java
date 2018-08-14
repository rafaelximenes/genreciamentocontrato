package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.Metrica;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoOS;
import br.gov.cgsus.gerenciamentocontrato.service.MetricaBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.TipoOSBusiness;

@ManagedBean
@ViewScoped
public class TipoOSController extends Controller {

	private TipoOS tipoOS;
	
	private List<TipoOS> listaTipoOSes;
	
	private List<TipoOS> listaFiltrada;
	
	private TipoOSBusiness tipoOSBusiness;
	
	private List<Metrica> listaMetricas;
	
	@PostConstruct
	public void inicializar() {
		tipoOSBusiness = new TipoOSBusiness();
		tipoOS = new TipoOS();
		pesquisar();
		pesquisarMetricas();
	}
	
	public void cadastrar() {
		try {
			tipoOSBusiness.inserir(tipoOS);
			jsfInfo("Tipo OS cadastrado com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	public void pesquisar() {
		try {
			listaTipoOSes = tipoOSBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	private void pesquisarMetricas() {
		MetricaBusiness metricaBusiness = new MetricaBusiness();
		try {
			listaMetricas =  metricaBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public void limparDados() {
		inicializar();
	}

	public TipoOS getTipoOS() {
		return tipoOS;
	}

	public void setTipoOS(TipoOS tipoOS) {
		this.tipoOS = tipoOS;
	}

	public List<TipoOS> getListaTipoOSes() {
		return listaTipoOSes;
	}

	public void setListaTipoOSes(List<TipoOS> listaTipoOSes) {
		this.listaTipoOSes = listaTipoOSes;
	}

	public List<TipoOS> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<TipoOS> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public List<Metrica> getListaMetricas() {
		return listaMetricas;
	}

	public void setListaMetricas(List<Metrica> listaMetricas) {
		this.listaMetricas = listaMetricas;
	}

	
}
