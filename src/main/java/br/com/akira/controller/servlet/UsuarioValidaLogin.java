package br.com.akira.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

public class UsuarioValidaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioValidaLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuarioValido = dao.usuarioValido(login, senha);

		HttpSession sessao = request.getSession();
		sessao.setMaxInactiveInterval(60*5);
		
		if (usuarioValido != null) {
			sessao.setAttribute("usuarioSessao", usuarioValido.getNome());
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		} else {
			request.setAttribute("messagem", "Usuario/Senha Inválido");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
