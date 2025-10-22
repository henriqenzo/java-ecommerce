package ucb.aplicacao.dao;

import ucb.aplicacao.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends BaseDAO {

    public void inserir(Produto p) {
        try {
            abrirConexao();
            String sql = "INSERT INTO Produto (nome, preco, tamanho, qtd_estoque, categoria_id) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setString(3, p.getTamanho());
            stmt.setInt(4, p.getQtdEstoque());
            stmt.setInt(5, p.getCategoriaId());
            stmt.executeUpdate();
            System.out.println("✅ Produto cadastrado!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        try {
            abrirConexao();
            stmt = conn.prepareStatement("SELECT * FROM Produto");
            rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("produto_id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("tamanho"),
                        rs.getInt("qtd_estoque"),
                        rs.getInt("categoria_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return produtos;
    }

    public void atualizar(Produto p) {
        try {
            abrirConexao();
            stmt = conn.prepareStatement(
                    "UPDATE Produto SET nome=?, preco=?, tamanho=?, qtd_estoque=?, categoria_id=? WHERE produto_id=?");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setString(3, p.getTamanho());
            stmt.setInt(4, p.getQtdEstoque());
            stmt.setInt(5, p.getCategoriaId());
            stmt.setInt(6, p.getId());
            stmt.executeUpdate();
            System.out.println("✅ Produto atualizado!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletar(int id) {
        try {
            abrirConexao();
            stmt = conn.prepareStatement("DELETE FROM Produto WHERE produto_id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("🗑️ Produto excluído!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }
}
