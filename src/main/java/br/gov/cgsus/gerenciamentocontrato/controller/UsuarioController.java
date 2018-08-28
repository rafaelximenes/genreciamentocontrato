package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.Perfil;
import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.service.ContratoBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.UsuarioBusiness;

@ManagedBean
@ViewScoped
public class UsuarioController extends Controller {

	private Usuario usuario;
	
	private Usuario usuarioSelected;
	
	private List<Usuario> listaUsuarioes;
	
	private List<Usuario> listaFiltrada;
	
	private UsuarioBusiness usuarioBusiness;
	
	private List<Contrato> listaContratos;
	
	private List<Perfil> listaPerfil;
	
	private List<String> listaPerfilString;
	
	private String perfilString;
	
	private Contrato contrato;
	
	private List<Contrato> listaContratosSelecteds;
	
	@PostConstruct
	public void inicializar() {
		usuarioBusiness = new UsuarioBusiness();
		usuario = new Usuario();
		perfilString = null;
		pesquisar();
		populaCombo();
		pesquisarListaCombos();
	}
	
	public void teste() {
		System.out.println(contrato);
	}
	
	public void vincularPerfilAoContrato() {
		
	}
	
	public void limparDadosVinculacao() {
		
	}
	
	private void populaCombo() {
		try {
			listaPerfil = usuarioBusiness.selectPerfil();
			listaPerfilString = new ArrayList<String>();
			for(Perfil p: listaPerfil) {
				listaPerfilString.add(p.getNome());
			}
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public void buscaPerfilPorNome() {
		for(Perfil p: listaPerfil) {
			if(p.getNome().equalsIgnoreCase(perfilString)) {
				usuario.setPerfil(p);
				break;
			}
		}
	}
	
	private void pesquisarListaCombos() {
		ContratoBusiness contratoBusiness = new ContratoBusiness();
		try {
			listaContratos = contratoBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
	}

	public void cadastrar() {
		try {
			usuarioBusiness.inserir(usuario);
			/*for(Contrato c: listaContratosSelecteds) {
				UsuarioContrato uc = new UsuarioContrato(usuario, c);
				usuarioBusiness.vincularUsuarioAoContrato(uc);
			}*/
			jsfInfo("Usuario cadastrado com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	public void pesquisar() {
		try {
			listaUsuarioes = usuarioBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public void limparDados() {
		inicializar();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarioes() {
		return listaUsuarioes;
	}

	public void setListaUsuarioes(List<Usuario> listaUsuarioes) {
		this.listaUsuarioes = listaUsuarioes;
	}

	public List<Usuario> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Usuario> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

	public List<String> getListaPerfilString() {
		return listaPerfilString;
	}

	public void setListaPerfilString(List<String> listaPerfilString) {
		this.listaPerfilString = listaPerfilString;
	}

	public String getPerfilString() {
		return perfilString;
	}

	public void setPerfilString(String perfilString) {
		this.perfilString = perfilString;
	}

	public List<Contrato> getListaContratos() {
		return listaContratos;
	}

	public void setListaContratos(List<Contrato> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public List<Contrato> getListaContratosSelecteds() {
		return listaContratosSelecteds;
	}

	public void setListaContratosSelecteds(List<Contrato> listaContratosSelecteds) {
		this.listaContratosSelecteds = listaContratosSelecteds;
	}

	public Usuario getUsuarioSelected() {
		return usuarioSelected;
	}

	public void setUsuarioSelected(Usuario usuarioSelected) {
		this.usuarioSelected = usuarioSelected;
	}

	
}
