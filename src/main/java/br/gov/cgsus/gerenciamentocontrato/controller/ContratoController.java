package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.Fornecedor;
import br.gov.cgsus.gerenciamentocontrato.domain.Metrica;
import br.gov.cgsus.gerenciamentocontrato.domain.MetricaVigencia;
import br.gov.cgsus.gerenciamentocontrato.domain.VigenciaContrato;
import br.gov.cgsus.gerenciamentocontrato.service.ContratoBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.FornecedorBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.MetricaBusiness;

@ManagedBean
@ViewScoped
public class ContratoController extends Controller {

	private Contrato contrato;
	
	private List<Contrato> listaContratos;
	
	private List<Contrato> listaFiltrada;
	
	private ContratoBusiness contratoBusiness;
	
	private MetricaVigencia metricaVigencia;
	
	private List<Fornecedor> listaFornecedores;
	
	private List<Metrica> listaMetricas;
	
	private VigenciaContrato vigenciaContrato;
	
	@PostConstruct
	public void inicializar() {
		contratoBusiness = new ContratoBusiness();
		contrato = new Contrato();
		vigenciaContrato = new VigenciaContrato();
		metricaVigencia = new MetricaVigencia();
		pesquisar();
		pesquisarFornecedores();
		pesquisarMetricas();
	}
	
	private void pesquisarMetricas() {
		MetricaBusiness metricaBusiness = new MetricaBusiness();
		try {
			listaMetricas =  metricaBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}

	private void pesquisarFornecedores() {
		FornecedorBusiness business = new FornecedorBusiness();
		try {
			listaFornecedores = business.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
	}

	public void cadastrar() {
		try {
			contratoBusiness.inserir(contrato, vigenciaContrato, metricaVigencia);
			jsfInfo("Contrato cadastrado com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	public void pesquisar() {
		try {
			listaContratos = contratoBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public void limparDados() {
		inicializar();
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public List<Contrato> getListaContratos() {
		return listaContratos;
	}

	public void setListaContratoes(List<Contrato> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public List<Contrato> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Contrato> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	public void setListaContratos(List<Contrato> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public VigenciaContrato getVigenciaContrato() {
		return vigenciaContrato;
	}

	public void setVigenciaContrato(VigenciaContrato vigenciaContrato) {
		this.vigenciaContrato = vigenciaContrato;
	}

	public MetricaVigencia getMetricaVigencia() {
		return metricaVigencia;
	}

	public void setMetricaVigencia(MetricaVigencia metricaVigencia) {
		this.metricaVigencia = metricaVigencia;
	}

	public List<Metrica> getListaMetricas() {
		return listaMetricas;
	}

	public void setListaMetricas(List<Metrica> listaMetricas) {
		this.listaMetricas = listaMetricas;
	}

	
}
