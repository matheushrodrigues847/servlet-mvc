package br.com.alura.acao;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresa implements Acao {
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
		//chamando a jsp -. java server page - foi alterado. A unica servlet esta chamando
		
		req.setAttribute("empresas", empresas);
		
		return "forward:listarEmpresas.jsp";
	}
}
