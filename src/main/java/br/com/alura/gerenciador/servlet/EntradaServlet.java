package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.acao.Acao;
import br.com.alura.acao.AlteraEmpresa;
import br.com.alura.acao.ListaEmpresa;
import br.com.alura.acao.MostraEmpresa;
import br.com.alura.acao.NovaEmpresa;
import br.com.alura.acao.NovaEmpresaForm;
import br.com.alura.acao.RemoveEmpresa;


@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAction = request.getParameter("acao");
		
//		HttpSession sessao = request.getSession();
//		
//		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado")==null;
//		boolean acaoProtegida = !(paramAction.equals("Login") || paramAction.equals("LoginForm")) ;
//		
//		if(acaoProtegida && usuarioNaoEstaLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
		
		
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
		
		
//		List<String> palavras = new ArrayList<String>();
//		
//		palavras.add("a");
//		palavras.add("b");
//		
//		palavras.sort(Comparator.comparing(String::hashCode));
//		
//		Collections.sort(palavras);
		
		
//		if(comparaString("ListaEmpresa", paramAction)) {
//			ListaEmpresa listaEmp = new ListaEmpresa();
//			nome = listaEmp.executa(request, response);
//			
//		} else if(comparaString("MostraEmpresa", paramAction)) {
//			MostraEmpresa mostraEmp = new MostraEmpresa();
//			nome = mostraEmp.executa(request, response);
//			
//		} else if(comparaString("RemoveEmpresa", paramAction)) {
//			RemoveEmpresa removeEmp = new RemoveEmpresa();
//			nome = removeEmp.executa(request, response);
//		} else if(comparaString("AlteraEmpresa", paramAction)) {
//			AlteraEmpresa alteraEmp = new AlteraEmpresa();
//			nome = alteraEmp.executa(request, response);
//		} else if(comparaString("NovaEmpresa", paramAction)) {
//			NovaEmpresa novaEmp = new NovaEmpresa();
//			nome = novaEmp.executa(request, response);
//		} else if(comparaString("NovaEmpresaForm", paramAction)) {
//			NovaEmpresaForm novaEmpForm = new NovaEmpresaForm();
//			nome = novaEmpForm.executa(request, response);
//		}
//		
//		String[] tipoEndereco = nome.split(":");
//		
//		if(tipoEndereco[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
//			rd.forward(request, response);
//		} else {
//			response.sendRedirect(tipoEndereco[1]);
//		}
		
	}
}
