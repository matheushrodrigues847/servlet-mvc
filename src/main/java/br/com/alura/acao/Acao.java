package br.com.alura.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	public String executa(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException;
}
