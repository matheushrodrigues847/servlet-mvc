package br.com.alura.acao;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Banco banco = new Banco();
		
		Optional<Usuario> usuarioExiste = banco.getUsuario(login, senha);
		
		if(Optional.empty() != null) {
			return "redirect:entrada?acao=LoginForm";
		}
		
		Usuario usuario = usuarioExiste.get();
		
		System.out.println("Login de " + login);
		
		//pega o cookie
		HttpSession sessao = req.getSession();
		//persistindo o dado do usuario
		sessao.setAttribute("usuarioLogado", usuario);
		
		
		return "redirect:entrada?acao=ListaEmpresa";
	}

}
