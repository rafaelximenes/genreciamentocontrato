package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.Metrica;
import br.gov.cgsus.gerenciamentocontrato.service.MetricaBusiness;

@ManagedBean
@ViewScoped
public class MetricaController extends Controller {

	private Metrica metrica;
	
	private List<Metrica> listaMetricas;
	
	private List<Metrica> listaFiltrada;
	
	private MetricaBusiness metricaBusiness;
	
	@PostConstruct
	public void inicializar() {
		metricaBusiness = new MetricaBusiness();
		metrica = new Metrica();
		pesquisar();
	}
	
	public void cadastrar() {
		try {
			metricaBusiness.inserir(metrica);
			jsfInfo("Métrica cadastrada com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	public void pesquisar() {
		try {
			listaMetricas = metricaBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public void limparDados() {
		inicializar();
	}

	public Metrica getMetrica() {
		return metrica;
	}

	public void setMetrica(Metrica metrica) {
		this.metrica = metrica;
	}

	public List<Metrica> getListaMetricas() {
		return listaMetricas;
	}

	public void setListaMetricas(List<Metrica> listaMetricas) {
		this.listaMetricas = listaMetricas;
	}

	public List<Metrica> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Metrica> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	
}
