package br.gov.cgsus.gerenciamentocontrato.controller;

import java.io.IOException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class LogoutController {

	public void logout() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("userSession", null);
		sessionMap.put("cpfUsuario", null);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/login/login.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void metodoNaoQuerSair() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/restricted/usuario.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}