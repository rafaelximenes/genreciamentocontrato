package br.gov.cgsus.gerenciamentocontrato.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.service.UsuarioBusiness;
import br.gov.cgsus.gerenciamentocontrato.session.UsuarioSessao;

@ManagedBean
@ViewScoped
public class AlterarDadosPessoaisController extends Controller {
	
	private Usuario usuario;
	
	private UsuarioBusiness usuarioBusiness;
	
	@ManagedProperty(value="#{usuarioSessao}")
	private UsuarioSessao usuarioSessao;
	
	public void setUsuarioSessao(UsuarioSessao usuarioSessao) { 
		this.usuarioSessao = usuarioSessao;
	}
	
	public void limparDados() {
		inicializar();
	}
	
	@PostConstruct
	public void inicializar() {
		usuarioBusiness = new UsuarioBusiness();
		usuario = usuarioSessao.getUsuario();
	}
	
	public void alterarUsuario() {
		try {
			usuarioBusiness.alteraUsuario(usuario);
			jsfInfo("Usuário alterado com sucesso!");
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioSessao getUsuarioSessao() {
		return usuarioSessao;
	}

}
