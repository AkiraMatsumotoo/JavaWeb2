package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

public class UsuarioTeste {

	public static void main(String[] args) throws SQLException {
		// adiciona();
		lista();
		// listaCompleta();
		// edita();
		// exclui();

	}

	private static void exclui() throws SQLException {
		Usuario u = new Usuario();
		u.setId(109);

		UsuarioDAO dao = new UsuarioDAO();
		dao.exclui(u);
	}

	private static void edita() throws SQLException {
		Usuario u = new Usuario();
		u.setNome("Bianca 1");
		u.setLogin("bianca 1");
		u.setSenha("bianca 1");
		u.setNivel(1);
		u.setId(61);

		UsuarioDAO dao = new UsuarioDAO();
		dao.edita(u);
	}

	private static void listaCompleta() throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		ArrayList<Usuario> lista = dao.buscarTodosCompleto(	"an", "nome", 15, 0);

		for (Usuario u : lista) {
			System.out.println("[ID:" + u.getId() + "] [Nome:" + u.getNome() + "] [Login:" + u.getLogin() + "]");
		}
	}

	private static void lista() throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		ArrayList<Usuario> lista = dao.buscarTodos();

		for (Usuario u : lista) {
			System.out.println("[ID:" + u.getId() + "] [Nome:" + u.getNome() + "] [Login:" + u.getLogin() + "]");
		}
	}

	private static void adiciona() throws SQLException {
		Usuario u = new Usuario();
		u.setNome("Akira Matsumoto");
		u.setLogin("akira");
		u.setSenha("123");
		u.setNivel(3);

		UsuarioDAO dao = new UsuarioDAO();
		dao.adicionar(u);
	}
}
