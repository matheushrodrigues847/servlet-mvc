package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;


@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String dataAbertura = request.getParameter("dataAbertura");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date data = null;
		
		try {
			data = sdf.parse(dataAbertura);
		}catch (Exception e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
//		Empresa alterandoEmpresa = banco.getEmpresa(id);
//		alterandoEmpresa.setCnpj(cnpj);
		
		Empresa empresa = new Empresa(nome, cnpj);
		empresa.setId(id);
		empresa.setDataAbertura(data);
		
		banco.alteraEmpresa(empresa);
		
		response.sendRedirect("listaEmpresas");
	}

}
