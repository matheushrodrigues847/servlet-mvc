package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi",loadOnStartup = 1)
public class helloWordServlet extends HttpServlet{
	
	public helloWordServlet() {
		System.out.println("Instanciando helloWorldServlet");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hello world, servlet");
		out.println("</body>");
		out.println("</html>");
	}
}
