package br.gov.cgsus.gerenciamentocontrato.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.gov.cgsus.gerenciamentocontrato.domain.Sistema;
import br.gov.cgsus.gerenciamentocontrato.domain.TamanhoFuncional;
import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.service.ChamadoSistemaOSBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.SistemaBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.TamanhoFuncionalBusiness;
import br.gov.cgsus.gerenciamentocontrato.session.UsuarioSessao;
import br.gov.cgsus.gerenciamentocontrato.utils.Util;

@ManagedBean
@ViewScoped
public class SistemaController extends Controller {

	private Sistema sistema;
	
	private List<Sistema> listaSistemaes;
	
	private List<Sistema> listaFiltrada;
	
	private SistemaBusiness sistemaBusiness;
	
	private Sistema sistemaSelected;
	
	
	private TamanhoFuncional tamanhoFuncional;
	
	private List<TamanhoFuncional> listaTamanhoFuncionales;
	
	private List<TamanhoFuncional> listaFiltradaTamanhoFuncional;
	
	private List<Sistema> listaSistemas;
	
	private TamanhoFuncionalBusiness tamanhoFuncionalBusiness;
	
	@ManagedProperty(value="#{usuarioSessao}")
	private UsuarioSessao usuarioSessao;
	
	public void setUsuarioSessao(UsuarioSessao usuarioSessao) { 
		this.usuarioSessao = usuarioSessao;
	}
	
	
	@PostConstruct
	public void inicializar() {
		Usuario usuario = usuarioSessao.getUsuario();
		if(!Util.temPerfilParaAcessar(usuario, usuarioSessao.getContrato(), 2)) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/public/erro_permissao.jsf");
			} catch (IOException e) {
				jsfError(e.getMessage());
			}
		}
		tamanhoFuncionalBusiness = new TamanhoFuncionalBusiness();
		tamanhoFuncional = new TamanhoFuncional();
		sistemaBusiness = new SistemaBusiness();
		sistema = new Sistema();
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
	
	public void alterar() {
		try {
			sistemaBusiness.alterar(sistemaSelected);
			jsfInfo("Alteração realizada com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
	}
	
	public void cadastrarTamanhoFuncional() {
		try {
			tamanhoFuncionalBusiness.inserir(tamanhoFuncional);
			jsfInfo("Tamanho Funcional cadastrado com sucesso!");
			pesquisarTamanhoFuncional();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDadosTamanhoFuncional();
		
	}
	
	public void limparDadosTamanhoFuncional() {
		tamanhoFuncional.setDataVigencia(null);
		tamanhoFuncional.setTamanhoPontoFuncao(null);
		
	}

	public void cadastrar() {
		try {
			sistemaBusiness.inserir(sistema);
			jsfInfo("Sistema cadastrado com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	public void pesquisar() {
		try {
			listaSistemaes = sistemaBusiness.selectAll();
			atribuiCoberturaTeste();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	private void atribuiCoberturaTeste() {
		ChamadoSistemaOSBusiness chamadoSistemaOSBusiness = new ChamadoSistemaOSBusiness();
		for(Sistema s: listaSistemaes) {
			try {
				s.setCoberturaTesteApurado(chamadoSistemaOSBusiness.selectUltimoChamadoPorSistema(s.getId()).getCoberturaTesteApurado());
			} catch (Exception e) {
				s.setCoberturaTesteApurado(null);
			}
		}
		
	}


	public void pesquisarTamanhoFuncional() {
		try {
			listaTamanhoFuncionales = tamanhoFuncionalBusiness.selectPorIdSistema(tamanhoFuncional);
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
	}
	
	public void limparDados() {
		inicializar();
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public List<Sistema> getListaSistemaes() {
		return listaSistemaes;
	}

	public void setListaSistemaes(List<Sistema> listaSistemaes) {
		this.listaSistemaes = listaSistemaes;
	}

	public List<Sistema> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Sistema> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public Sistema getSistemaSelected() {
		return sistemaSelected;
	}

	public void setSistemaSelected(Sistema sistemaSelected) {
		if(sistemaSelected!=null) {
			this.sistemaSelected = sistemaSelected;
			tamanhoFuncional = new TamanhoFuncional();
			tamanhoFuncional.setSistema(sistemaSelected);
			try {
				listaTamanhoFuncionales = tamanhoFuncionalBusiness.selectPorIdSistema(tamanhoFuncional);
			} catch (Exception e) {
				jsfError(e.getMessage());
			}
		}
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

	public List<TamanhoFuncional> getListaFiltradaTamanhoFuncional() {
		return listaFiltradaTamanhoFuncional;
	}

	public void setListaFiltradaTamanhoFuncional(List<TamanhoFuncional> listaFiltradaTamanhoFuncional) {
		this.listaFiltradaTamanhoFuncional = listaFiltradaTamanhoFuncional;
	}

	public List<Sistema> getListaSistemas() {
		return listaSistemas;
	}

	public void setListaSistemas(List<Sistema> listaSistemas) {
		this.listaSistemas = listaSistemas;
	}

	
}
