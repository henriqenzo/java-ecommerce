package ucb.aplicacao.dao;

import ucb.aplicacao.model.ItemPedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDAO extends BaseDAO {

    public void inserir(ItemPedido item) {
        try {
            abrirConexao();
            String sql = "INSERT INTO ItemPedido (pedido_id, produto_id, qtd) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, item.getPedidoId());
            stmt.setInt(2, item.getProdutoId());
            stmt.setInt(3, item.getQtd());
            stmt.executeUpdate();
            System.out.println("✅ Item adicionado ao pedido!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<ItemPedido> listar() {
        List<ItemPedido> itens = new ArrayList<>();
        try {
            abrirConexao();
            stmt = conn.prepareStatement("SELECT * FROM ItemPedido");
            rs = stmt.executeQuery();
            while (rs.next()) {
                itens.add(new ItemPedido(
                        rs.getInt("pedido_id"),
                        rs.getInt("produto_id"),
                        rs.getInt("qtd")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return itens;
    }
}
