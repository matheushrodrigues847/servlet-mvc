package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet(urlPatterns = "/listaEmpresas")
public class ListaEmpresaServLet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
		//chamando a jsp -. java server page
		RequestDispatcher rd = req.getRequestDispatcher("/listarEmpresas.jsp");
		req.setAttribute("empresas", empresas);
		rd.forward(req, resp);
	}
}
