package br.com.akira.controller.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = new Usuario();

		String acao = request.getParameter("acao");
		String numeroPagina = request.getParameter("numPagina");
		String order = request.getParameter("order");
		String like = request.getParameter("like");
		String buscarPor = request.getParameter("buscarPor");

		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nivel = request.getParameter("nivel");

		if (acao == null) {
			acao = "listar";
		}
		if (numeroPagina == null) {
			numeroPagina = "1";
		}
		if (order == null) {
			order = "id";
		}
		if (like == null) {
			like = "";
		}
		if (buscarPor == null) {
			buscarPor = "nome";
		}

		int limit = 16;
		int offset = (Integer.parseInt(numeroPagina) * limit) - limit;

		// pega a quantidade de registro de Usuario no banco
		int qtdRegistro = dao.qtdRegistro(buscarPor, like);

		// Dividi a qtd com o limit para saber o total de pagina
		int paginacao = (qtdRegistro / limit);

		// Se a divisão da pagina com o limit for diferente de zero,
		// soma mais 1
		if (paginacao % limit != 0) {
			paginacao++;
		}

		if (acao.equals("listar")) {
			dao = new UsuarioDAO();
			ArrayList<Usuario> lista = dao.buscarTodosCompleto(buscarPor, like, order, limit, offset);

			request.setAttribute("paginacao", paginacao);
			request.setAttribute("listaUsuario", lista);
			request.getRequestDispatcher("WEB-INF/usuLista.jsp").forward(request, response);
		}

		else if (acao.equals("buscar")) {
			dao = new UsuarioDAO();
			ArrayList<Usuario> lista = dao.buscarTodosCompleto(buscarPor, like, order, limit, offset);

			request.setAttribute("paginacao", paginacao);
			request.setAttribute("listaUsuario", lista);
			request.getRequestDispatcher("WEB-INF/usuLista.jsp").forward(request, response);
		}

		else if (acao.equals("excluir")) {
			dao = new UsuarioDAO();
			u.setId(Integer.parseInt(id));
			dao.exclui(u);

			response.sendRedirect("UsuarioController");
		}

		else if (acao.equals("editar")) {
			dao = new UsuarioDAO();

			Usuario usuarioBuscado = dao.buscarID(Integer.parseInt(id));
			request.setAttribute("usuarioBuscado", usuarioBuscado);
			request.getRequestDispatcher("WEB-INF/usuEditar.jsp").forward(request, response);
		}

		else if (acao.equals("adiciona")) {
			request.getRequestDispatcher("WEB-INF/usuAdiciona.jsp").forward(request, response);
		}

		else if (acao.equals("salvar")) {
			dao = new UsuarioDAO();
			u.setId(Integer.parseInt(id));
			u.setNome(nome);
			u.setLogin(login);
			u.setSenha(senha);
			u.setNivel(Integer.parseInt(nivel));

			dao.salvar(u);
			response.sendRedirect("UsuarioController");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
