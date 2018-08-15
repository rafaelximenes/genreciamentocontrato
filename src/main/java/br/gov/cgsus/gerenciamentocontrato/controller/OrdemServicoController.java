package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.OrdemServico;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoOS;
import br.gov.cgsus.gerenciamentocontrato.service.ContratoBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.OrdemServicoBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.TipoOSBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.VigenciaContratoBusiness;
import br.gov.cgsus.gerenciamentocontrato.utils.Util;

@ManagedBean
@ViewScoped
public class OrdemServicoController extends Controller {

	private OrdemServico ordemServico;
	
	private OrdemServico ordemServicoSelected;
	
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
	
	public void buscaNovoNumeroOS() {
		if(ordemServico.getContrato()!=null && ordemServico.getTipoOS()!=null && ordemServico.getAno()!=null) { 
			OrdemServicoBusiness ordemServicoBusiness = new OrdemServicoBusiness();
			try {
				ordemServico.setNumero(ordemServicoBusiness.selectUltimoNumeroPorAno(ordemServico));
			} catch (Exception e) {
				jsfError(e.getMessage());
				ordemServico.setNumero(1); 
			}
		}
		
	}
	
	public void calculaQtdDias() {
		if(ordemServico.getDataInicioPeriodo()!=null && ordemServico.getDataFimPeriodo()!=null) {
			ordemServico.setQtdDias(Util.diferencaDeDiasEntreDatas(ordemServico.getDataInicioPeriodo(), ordemServico.getDataFimPeriodo()));
		}
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
			buscaVigenciaPelaDataAbertura();
			ordemServicoBusiness.inserir(ordemServico);
			jsfInfo("Ordem de Serviço cadastrada com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	private void buscaVigenciaPelaDataAbertura() {
		VigenciaContratoBusiness vigenciaContratoBusiness = new VigenciaContratoBusiness();
		try {
			ordemServico.setVigenciaContrato(vigenciaContratoBusiness.selectVigenciaValidaPorContrato(ordemServico));
		} catch (Exception e) {
			jsfError(e.getMessage());
			ordemServico.setVigenciaContrato(null);
		}
		
	}

	public void pesquisar() {
		try {
			listaOrdemServicoes = ordemServicoBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public String chamaPaginaVincularSistemas() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("os_user", ordemServicoSelected);
		return "/poseidon/sistema_os.jsf?faces-redirect=true";
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

	public OrdemServico getOrdemServicoSelected() {
		return ordemServicoSelected;
	}

	public void setOrdemServicoSelected(OrdemServico ordemServicoSelected) {
		if(ordemServicoSelected!=null) {
			this.ordemServicoSelected = ordemServicoSelected;
		}
	}

	
}
