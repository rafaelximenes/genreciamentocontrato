package br.gov.cgsus.gerenciamentocontrato.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.Perfil;
import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.domain.UsuarioContrato;
import br.gov.cgsus.gerenciamentocontrato.service.ContratoBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.UsuarioBusiness;
import br.gov.cgsus.gerenciamentocontrato.session.UsuarioSessao;
import br.gov.cgsus.gerenciamentocontrato.utils.Util;

@ManagedBean
@ViewScoped
public class LoginController {
	
	private String email;
	
	private String senha;
	
	private Usuario usuario;
	
	private List<Contrato> listaContrato;
	
	private Contrato contrato;
	
	@ManagedProperty(value="#{usuarioSessao}")
	private UsuarioSessao usuarioSessao;
	
	public void setUsuarioSessao(UsuarioSessao usuarioSessao) { 
		this.usuarioSessao = usuarioSessao;
	}
	
	@PostConstruct
	public void inicializar() {
		
	}
	
	public void preencheContratoPorUsuario() {
		ContratoBusiness contratoBusiness = new ContratoBusiness();
		try {
			listaContrato = contratoBusiness.selectContratosPorEmail(email);
			if(listaContrato.size()>0)
				contrato = listaContrato.get(0);
		} catch (Exception e) {
			listaContrato = new ArrayList<Contrato>();
		}
	}
	
	public void entrar() {
		Integer perfilId;
		if(contrato==null) {
			jsfError("Contrato precisa ser preenchido.");
			return;
		}
		usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(Util.geraSHA256(senha));
		Usuario u;
		UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
		try {
			u = usuarioBusiness.selectByEmailSenha(usuario);
			if(u==null) {
				jsfError("Usuário/Senha inválido(s)");
				return;
			}
			UsuarioContrato uc = new UsuarioContrato();
			uc.setContrato(new Contrato(contrato.getId()));
			uc.setUsuario(new Usuario(u.getId()));
			perfilId = usuarioBusiness.selectPerfilUsuario(uc);
			Perfil perfil = new Perfil(perfilId);
			usuarioSessao.setPerfil(perfil);
			usuarioSessao.setContrato(contrato);
			usuarioSessao.setUsuario(u);
		} catch (Exception e) {
			jsfError(e.getMessage());
			return;
		}
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/restricted/dashboard.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void jsfInfo(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensagem));
    }
    
    public void jsfWarn(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", mensagem));
    }
    
    public void jsfError(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", mensagem));
    }
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Contrato> getListaContrato() {
		return listaContrato;
	}

	public void setListaContrato(List<Contrato> listaContrato) {
		this.listaContrato = listaContrato;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	
	
	

}
