package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

@WebServlet(urlPatterns = "/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		banco.remove(Integer.parseInt(req.getParameter("id")));
		resp.sendRedirect("listaEmpresas");
	}
}