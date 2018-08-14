package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.OrdemServico;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoOS;
import br.gov.cgsus.gerenciamentocontrato.service.ContratoBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.OrdemServicoBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.TipoOSBusiness;

@ManagedBean
@ViewScoped
public class OrdemServicoController extends Controller {

	private OrdemServico ordemServico;
	
	private List<OrdemServico> listaOrdemServicoes;
	
	private List<OrdemServico> listaFiltrada;
	
	private List<Contrato> listaContratos;
	
	private List<TipoOS> listaTipoOS;
	
	private OrdemServicoBusiness ordemServicoBusiness;
	
	@PostConstruct
	public void inicializar() {
		ordemServicoBusiness = new OrdemServicoBusiness();
		ordemServico = new OrdemServico();
		pesquisar();
		pesquisarListaCombos();
	}
	
	private void pesquisarListaCombos() {
		ContratoBusiness contratoBusiness = new ContratoBusiness();
		try {
			listaContratos = contratoBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		TipoOSBusiness tipoOSBusiness = new TipoOSBusiness();
		try {
			listaTipoOS = tipoOSBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}

	public void cadastrar() {
		try {
			ordemServicoBusiness.inserir(ordemServico);
			jsfInfo("OrdemServico cadastrado com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	public void pesquisar() {
		try {
			listaOrdemServicoes = ordemServicoBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public void limparDados() {
		inicializar();
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<OrdemServico> getListaOrdemServicoes() {
		return listaOrdemServicoes;
	}

	public void setListaOrdemServicoes(List<OrdemServico> listaOrdemServicoes) {
		this.listaOrdemServicoes = listaOrdemServicoes;
	}

	public List<OrdemServico> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<OrdemServico> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public List<Contrato> getListaContratos() {
		return listaContratos;
	}

	public void setListaContratos(List<Contrato> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public List<TipoOS> getListaTipoOS() {
		return listaTipoOS;
	}

	public void setListaTipoOS(List<TipoOS> listaTipoOS) {
		this.listaTipoOS = listaTipoOS;
	}

	
}
