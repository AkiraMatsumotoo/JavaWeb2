package br.com.akira.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.akira.bean.model.Usuario;

public class UsuarioDAO {
	Connection conn = ConnectionFactory.getConnection();
	ResultSet rs = null;

	public void adicionar(Usuario u) {
		String sql = "INSERT INTO usuario (nome,login,senha,nivel)VALUES(?,?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getNivel());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void exclui(Usuario u) {
		String sql = "DELETE FROM usuario WHERE id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, u.getId());
			ps.execute();
			conn.close();
			System.out.println("Excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void edita(Usuario u) {
		String sql = "UPDATE usuario SET nome=?, login=?, senha=?, nivel=? WHERE id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getNivel());
			ps.setInt(5, u.getId());
			ps.execute();
			System.out.println("Editado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void salvar(Usuario u) {
		if (u.getId() == 0) {
			adicionar(u);
		} else {
			edita(u);
		}
	}

	public Usuario usuarioValido(String login, String senha) {
		String sql = "SELECT * FROM usuario WHERE login=? AND senha=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Usuario buscarID(int id) {
		String sql = "SELECT * FROM usuario WHERE id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Usuario> buscarNome(String nome) {
		String sql = "SELECT * FROM usuario WHERE nome=?";
		ArrayList<Usuario> lista = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, nome);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				lista.add(u);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Usuario> buscarLogin(String login) {
		String sql = "SELECT * FROM usuario WHERE nome=?";
		ArrayList<Usuario> lista = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, login);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				lista.add(u);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Usuario> buscarTodosCompleto(String buscarPor, String like, String order, int limit, int offset) {
		String sql = "SELECT * FROM usuario WHERE " + buscarPor + " LIKE ? ORDER BY " + order + " ASC LIMIT ? OFFSET ?";
		ArrayList<Usuario> lista = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			// ps.setString(1, buscarPor);
			ps.setString(1, "%" + like + "%");
			ps.setInt(2, limit);
			ps.setInt(3, offset);

			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				lista.add(u);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				// conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Usuario> buscarTodos() {
		String sql = "SELECT * FROM usuario";
		ArrayList<Usuario> lista = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				lista.add(u);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int qtdRegistro(String buscarPor, String like) {
		String sql = "SELECT COUNT(*) AS qtdUsuario FROM usuario WHERE " + buscarPor + " LIKE ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + like + "%");
			rs = ps.executeQuery();
			if (rs.next()) {
				int qtd = rs.getInt("qtdUsuario");
				return qtd;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				// conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

}
