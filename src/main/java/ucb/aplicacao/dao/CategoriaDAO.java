package ucb.aplicacao.dao;

import ucb.aplicacao.model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO extends BaseDAO {

    public void inserir(Categoria c) {
        try {
            abrirConexao();
            stmt = conn.prepareStatement("INSERT INTO Categoria (nome) VALUES (?)");
            stmt.setString(1, c.getNome());
            stmt.executeUpdate();
            System.out.println("✅ Categoria cadastrada!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            abrirConexao();
            stmt = conn.prepareStatement("SELECT * FROM Categoria");
            rs = stmt.executeQuery();
            while (rs.next()) {
                categorias.add(new Categoria(rs.getInt("categoria_id"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return categorias;
    }

    public void atualizar(Categoria c) {
        try {
            abrirConexao();
            stmt = conn.prepareStatement("UPDATE Categoria SET nome=? WHERE categoria_id=?");
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getId());
            stmt.executeUpdate();
            System.out.println("✅ Categoria atualizada!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletar(int id) {
        try {
            abrirConexao();
            stmt = conn.prepareStatement("DELETE FROM Categoria WHERE categoria_id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("🗑️ Categoria excluída!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }
}
