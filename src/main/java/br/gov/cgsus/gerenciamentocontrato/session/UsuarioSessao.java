package br.gov.cgsus.gerenciamentocontrato.session;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.Perfil;
import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioSessao {
	
	private Usuario usuario;
	
	private Contrato contrato;
	
	//1 - Administrador
	//2 - Fiscal Técnico
	//3 - Contratada
	//4 - Equipe Técnica
	//5 - Fiscal Requisitante
	private Perfil perfil;
	
	
	@PostConstruct
	public void inicializar() {
	}
	 
	public String lougout() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("userSession", null);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.jsf?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		if(usuario!=null) {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put("userSession", usuario);
			sessionMap.put("contrato", contrato);
			sessionMap.put("perfil", perfil);
		}
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public boolean isCadastroSistema() {
		if(perfil==null)
			return false;
		if(perfil.getId()==null)
			return false;
		if(perfil.getId().intValue()==1 || perfil.getId().intValue()==2 || perfil.getId().intValue()==4) {
			return true;
		}
		return false;
	}
}