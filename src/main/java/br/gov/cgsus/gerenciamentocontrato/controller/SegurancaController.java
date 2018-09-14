package br.gov.cgsus.gerenciamentocontrato.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.service.UsuarioBusiness;
import br.gov.cgsus.gerenciamentocontrato.session.UsuarioSessao;
import br.gov.cgsus.gerenciamentocontrato.utils.Util;

@ViewScoped
@ManagedBean
public class SegurancaController extends Controller {
	
	private String senha;
	
	private String novaSenha;
	
	private String confirmacaoSenha;
	
	private Usuario usuario;
	
	@ManagedProperty(value="#{usuarioSessao}")
	private UsuarioSessao usuarioSessao;
	
	public void setUsuarioSessao(UsuarioSessao usuarioSessao) { 
		this.usuarioSessao = usuarioSessao;
	}
	
	@PostConstruct
	public void inicializar() {
		senha = null;
		confirmacaoSenha = null;
		usuario = new Usuario();
		usuario = usuarioSessao.getUsuario();
	}
	
	public void limparDados() {
		inicializar();
	}
	
	public void alteraSenha() {
		if(usuario!=null) {
			if(!usuario.getSenha().equalsIgnoreCase(Util.geraSHA256(senha))) {
				jsfError("Senha atual incorreta;");
				return;
			}
			if(!novaSenha.equalsIgnoreCase(confirmacaoSenha)) {
				jsfError("A confirmação da senha deve ser igual a nova senha;");
				return;
			}
			UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
			try {
				usuario.setSenha(Util.geraSHA256(novaSenha));
				usuarioBusiness.alteraSenha(usuario);
				jsfInfo("Senha atualizada com sucesso!");
				limparDados();
			} catch (Exception e) {
				jsfError(e.getMessage());
			}
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub
		
	}

}
