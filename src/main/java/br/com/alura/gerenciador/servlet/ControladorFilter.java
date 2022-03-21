package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.acao.Acao;


//@WebFilter("/entrada")  pela anotacao n é possível definir a ordem de exec dos filters. Usar xml
//os interceptors, do spring, são diferentes dos filters
//eles atuam entre o controlador ou controlador filter e as ações
public class ControladorFilter extends HttpFilter implements Filter {
       
    
	 @Override
	 public void init() throws ServletException {
	    	
	 }
	    
	 @Override
	 public void destroy() {
	    	
	 }
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.alura.acao."+paramAction;
		
		
		
		//esse bloco de codigo substitui todos os if's
		//reflection
		
		String nome = null;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		} 
		
		
		String[] tipoEndereco = nome.split(":");
		
		
		
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
	}

	

}
