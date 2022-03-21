package br.com.alura.acao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		
//		response.sendRedirect("entrada?acao=listaEmpresas");
		return "redirect:entrada?acao=ListaEmpresa";
	}

}
