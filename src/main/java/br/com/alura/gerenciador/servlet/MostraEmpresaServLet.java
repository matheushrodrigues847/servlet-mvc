package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class MostraEmpresa
 */
@WebServlet("/mostraEmpresa")
public class MostraEmpresaServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empresaId = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.getEmpresa(empresaId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/alteraEmpresa.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);
		
	}

}
