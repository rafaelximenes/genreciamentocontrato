package br.gov.cgsus.gerenciamentocontrato.filter;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
public class SessionContext {
    
    private static SessionContext instance;
    
    public static SessionContext getInstance(){
       if (instance == null){
           instance = new SessionContext();
       }
       
       return instance;
    }
    
    private SessionContext(){
       
    }
    
    private ExternalContext currentExternalContext(){
       if (FacesContext.getCurrentInstance() == null){
           throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
       }else{
           return FacesContext.getCurrentInstance().getExternalContext();
       }
    }
    
    @SuppressWarnings("static-access")
	private ExternalContext currentExternalContext(HttpServletRequest rq, HttpServletResponse rp){
       if (FacesUtil.getFacesContext(rq, rp).getCurrentInstance() == null){
           throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
       }else{
           return FacesUtil.getFacesContext(rq, rp).getCurrentInstance().getExternalContext();
       }
    }
    
    
    public void encerrarSessao(){
       currentExternalContext().invalidateSession();
    }
    
    public Object getAttribute(String nome){
       return currentExternalContext().getSessionMap().get(nome);
    }
    
    public Object getAttribute(HttpServletRequest rq, HttpServletResponse rp, String nome){
        return currentExternalContext(rq,rp).getSessionMap().get(nome);
     }
    
    public void setAttribute(String nome, Object valor){
       currentExternalContext().getSessionMap().put(nome, valor);
    }
    
}
