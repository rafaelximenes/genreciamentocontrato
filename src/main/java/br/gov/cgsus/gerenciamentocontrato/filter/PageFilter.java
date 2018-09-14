package br.gov.cgsus.gerenciamentocontrato.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
 
public class PageFilter implements Filter {
 
    public void destroy() {
       // TODO Auto-generated method stub
 
    }
 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
  
        String newCurrentPage = ((HttpServletRequest) request).getServletPath();
  
        if(isPaginaParaUsuariosLogado(newCurrentPage)){
     	   HttpServletResponse res1 = (HttpServletResponse) response;
     	   HttpServletRequest req1 = (HttpServletRequest) request;
     	   Usuario user = (Usuario)SessionContext.getInstance().getAttribute(req1, res1, "userSession");
     	   if(user==null) {
     		   ((HttpServletResponse) response).sendRedirect("login.jsf");
 	    	   return;
     	   }
        }
        chain.doFilter(request, response);
  
     }
    
    private boolean isPaginaParaUsuariosLogado(String pagina) {
    	if(pagina.contains("login"))
    		return false;
    	/*if(pagina.contains("perfil") || pagina.contains("alerta") || pagina.contains("suporte") || pagina.contains("pagamento") || pagina.contains("alteraSenha") || pagina.contains("sair")
    			|| pagina.contains("job") || pagina.contains("dashboard") || pagina.contains("grafico") ) {
    		return true;
    	}*/
    	return true;
    	
    }
 
    public void init(FilterConfig arg0) throws ServletException {
       // TODO Auto-generated method stub
 
    }
}