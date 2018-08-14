package br.gov.cgsus.gerenciamentocontrato.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class Controller {
	
	public abstract void inicializar();
	
	public abstract void cadastrar();
	
	public abstract void pesquisar();
	
	public void jsfInfo(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensagem));
    }
    
    public void jsfWarn(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", mensagem));
    }
    
    public void jsfError(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", mensagem));
    }

}
