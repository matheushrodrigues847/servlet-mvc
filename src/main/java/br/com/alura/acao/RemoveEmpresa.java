package br.com.alura.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao{
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Banco banco = new Banco();
		banco.remove(Integer.parseInt(req.getParameter("id")));
		
		return "redirect:entrada?acao=ListaEmpresa";
	}
}
