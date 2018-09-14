package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.ChamadoSistemaOS;
import br.gov.cgsus.gerenciamentocontrato.domain.Sistema;
import br.gov.cgsus.gerenciamentocontrato.domain.SistemaOS;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoAceite;
import br.gov.cgsus.gerenciamentocontrato.service.ChamadoSistemaOSBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.SistemaOSBusiness;

@ManagedBean
@ViewScoped
public class ChamadoSistemaOSController extends Controller {

	private ChamadoSistemaOS chamadoSistemaOS;
	
	private List<ChamadoSistemaOS> listaChamadoSistemaOSes;
	
	private List<ChamadoSistemaOS> listaFiltrada;
	
	private ChamadoSistemaOSBusiness chamadoSistemaOSBusiness;
	
	private List<TipoAceite> listaTipoAceite;
	
	private List<Sistema> listaSistemas;
	
	private List<SistemaOS> listaSistemasOS;
	
	@PostConstruct
	public void inicializar() {
		chamadoSistemaOSBusiness = new ChamadoSistemaOSBusiness();
		chamadoSistemaOS = new ChamadoSistemaOS();
		chamadoSistemaOS.setSistemaOS(new SistemaOS());
		pesquisar();
		populaCombo();
	}
	
	private void populaCombo() {
		ChamadoSistemaOSBusiness chamadoSistemaOSBusiness = new ChamadoSistemaOSBusiness();
		try {
			listaTipoAceite = chamadoSistemaOSBusiness.selectTipoAceite();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		SistemaOSBusiness sistemaOSBusiness = new SistemaOSBusiness();
		try {
			listaSistemasOS = sistemaOSBusiness.selectSistemasAtivosDasOSAtivas();
			listaSistemas = new ArrayList<Sistema>();
			for(SistemaOS so: listaSistemasOS) {
				listaSistemas.add(so.getSistema());
			}
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}

	public void cadastrar() {
		try {
			for(SistemaOS so:listaSistemasOS) {
				if(so.getSistema().equals(chamadoSistemaOS.getSistemaOS().getSistema())) {					
					chamadoSistemaOS.setSistemaOS(so);
					break;
				}
			}
			chamadoSistemaOSBusiness.inserir(chamadoSistemaOS);
			jsfInfo("ChamadoSistemaOS cadastrado com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	public void pesquisar() {
		try {
			listaChamadoSistemaOSes = chamadoSistemaOSBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public void limparDados() {
		inicializar();
	}

	public ChamadoSistemaOS getChamadoSistemaOS() {
		return chamadoSistemaOS;
	}

	public void setChamadoSistemaOS(ChamadoSistemaOS chamadoSistemaOS) {
		this.chamadoSistemaOS = chamadoSistemaOS;
	}

	public List<ChamadoSistemaOS> getListaChamadoSistemaOSes() {
		return listaChamadoSistemaOSes;
	}

	public void setListaChamadoSistemaOSes(List<ChamadoSistemaOS> listaChamadoSistemaOSes) {
		this.listaChamadoSistemaOSes = listaChamadoSistemaOSes;
	}

	public List<ChamadoSistemaOS> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<ChamadoSistemaOS> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public List<TipoAceite> getListaTipoAceite() {
		return listaTipoAceite;
	}

	public void setListaTipoAceite(List<TipoAceite> listaTipoAceite) {
		this.listaTipoAceite = listaTipoAceite;
	}

	public List<Sistema> getListaSistemas() {
		return listaSistemas;
	}

	public void setListaSistemas(List<Sistema> listaSistemas) {
		this.listaSistemas = listaSistemas;
	}

	public List<SistemaOS> getListaSistemasOS() {
		return listaSistemasOS;
	}

	public void setListaSistemasOS(List<SistemaOS> listaSistemasOS) {
		this.listaSistemasOS = listaSistemasOS;
	}

	
}
