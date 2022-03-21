package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresaServLet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//doPost só recebe chamada pelo metodo POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		//recebendo os parametros pelo metodo POST
		String nomeEmpresa = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String dataAbertura = request.getParameter("dataAbertura");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date data = null;
		
		try {
			 data = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = new Empresa(nomeEmpresa, cnpj);
		empresa.setDataAbertura(data);
		
		banco.adicionar(empresa);
		
		request.setAttribute("empresa", empresa);
		
		//o navegador irá fazer essa nova requisicao (client side)
		//empresa nao será passada nessa nova requisicao
		response.sendRedirect("listaEmpresas");
		
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa);
//		rd.forward(request, response);
	}

}
