package br.com.alura.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		//removendo o cookie
//		session.removeAttribute("usuarioLogado");
		
		//destroi o cookie
		session.invalidate();
		
		return "redirect:entrada?acao=LoginForm";
	}

}
