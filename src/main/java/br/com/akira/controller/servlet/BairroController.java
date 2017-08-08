package br.com.akira.controller.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.bean.model.Bairro;
import br.com.akira.dao.jdbc.BairroDAO;

public class BairroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BairroController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BairroDAO dao= new BairroDAO();
		Bairro b = new Bairro();

		String acao = request.getParameter("acao");
		String numeroPagina = request.getParameter("numPagina");
		String like = request.getParameter("like");
		String orderBy = request.getParameter("orderBy");

		String bairro_id = request.getParameter("bairro_id");
		String bairro_descricao = request.getParameter("bairro_descricao");

		if (acao == null) {
			acao = "listar";
		}
		if (numeroPagina == null) {
			numeroPagina = "1";
		}
		if (like == null) {
			like = "";
		}
		if(orderBy == null){
			orderBy="bairro_id";
		}

		int limit = 16;
		int offset = (Integer.parseInt(numeroPagina) * limit) - limit;

		// pega a quantidade de registro de Usuario no banco
		int qtdRegistro = dao.qtdRegistro(like);

		// Dividi a qtd com o limit para saber o total de pagina
		int paginacao = (qtdRegistro / limit);

		// Se a divisão da pagina com o limit for diferente de zero,
		// soma mais 1
		if (paginacao % limit != 0) {
			paginacao++;
		}

		if (acao.equals("listar")) {
			dao = new BairroDAO();
			ArrayList<Bairro> lista = dao.buscarTodosCompleto(like, orderBy, limit, offset);

			request.setAttribute("paginacao", paginacao);
			request.setAttribute("listaBairro", lista);
			request.getRequestDispatcher("WEB-INF/baiLista.jsp").forward(request, response);
		}

		else if (acao.equals("buscar")) {
			dao = new BairroDAO();
			ArrayList<Bairro> lista = dao.buscarTodosCompleto(like, orderBy, limit, offset);

			request.setAttribute("paginacao", paginacao);
			request.setAttribute("listaBairro", lista);
			request.getRequestDispatcher("WEB-INF/baiLista.jsp").forward(request, response);
		}

		else if (acao.equals("excluir")) {
			dao = new BairroDAO();
			b.setBairro_id(Integer.parseInt(bairro_id));
			dao.exclui(b);

			response.sendRedirect("BairroController");
		}

		else if (acao.equals("editar")) {
			dao = new BairroDAO();

			Bairro bairroBuscado = dao.buscarID(Integer.parseInt(bairro_id));
			request.setAttribute("bairroBuscado", bairroBuscado);
			request.getRequestDispatcher("WEB-INF/baiEditar.jsp").forward(request, response);
		}

		else if (acao.equals("adiciona")) {
			request.getRequestDispatcher("WEB-INF/baiAdiciona.jsp").forward(request, response);
		}

		else if (acao.equals("salvar")) {
			dao = new BairroDAO();
			b.setBairro_id(Integer.parseInt(bairro_id));
			b.setBairro_descricao(bairro_descricao);

			dao.salvar(b);
			response.sendRedirect("BairroController");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
