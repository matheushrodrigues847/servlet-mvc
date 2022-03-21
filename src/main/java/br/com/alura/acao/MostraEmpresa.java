package br.com.alura.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empresaId = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.getEmpresa(empresaId);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/alteraEmpresa.jsp");
		request.setAttribute("empresa", empresa);
//		rd.forward(request, response);
		
		return "forward:alteraEmpresa.jsp";
	}
}
