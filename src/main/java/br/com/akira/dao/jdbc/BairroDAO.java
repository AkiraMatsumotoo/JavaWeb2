package br.com.akira.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.akira.bean.model.Bairro;

public class BairroDAO {

	Connection conn = ConnectionFactory.getConnection();
	ResultSet rs = null;

	public void adicionar(Bairro b) {
		String sql = "INSERT INTO bairro(bairro_descricao)VALUES(?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, b.getBairro_descricao());
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

	public void exclui(Bairro b) {
		String sql = "DELETE FROM bairro WHERE bairro_id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, b.getBairro_id());
			System.out.println("SQL : " + ps.toString());
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

	public void edita(Bairro b) {
		String sql = "UPDATE bairro SET bairro_descricao=? WHERE bairro_id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, b.getBairro_descricao());
			ps.setInt(2, b.getBairro_id());
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

	public void salvar(Bairro b) {
		if (b.getBairro_id() == 0) {
			adicionar(b);
		} else {
			edita(b);
		}
	}

	public Bairro buscarID(int id) {
		String sql = "SELECT * FROM bairro WHERE bairro_id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Bairro b = new Bairro();
				b.setBairro_id(rs.getInt("bairro_id"));
				b.setBairro_descricao(rs.getString("bairro_descricao"));
				return b;
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

	public ArrayList<Bairro> buscarTodosCompleto(String like, String orderBy, int limit, int offset) {
		String sql = "SELECT * FROM bairro WHERE bairro_descricao LIKE ? ORDER BY " + orderBy + " ASC LIMIT ? OFFSET ?";
		ArrayList<Bairro> lista = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + like + "%");
			ps.setInt(2, limit);
			ps.setInt(3, offset);
			System.out.println("SQL : " + ps.toString());

			rs = ps.executeQuery();
			while (rs.next()) {
				Bairro u = new Bairro();
				u.setBairro_id(rs.getInt("bairro_id"));
				u.setBairro_descricao(rs.getString("bairro_descricao"));
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

	public int qtdRegistro(String like) {
		String sql = "SELECT COUNT(*) AS qtdBairro FROM bairro WHERE bairro_descricao LIKE ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + like + "%");
			rs = ps.executeQuery();
			if (rs.next()) {
				int qtd = rs.getInt("qtdBairro");
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
