package ucb.aplicacao.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ucb.aplicacao.model.Pedido;

public class PedidoDAO extends BaseDAO {

    public void inserir(Pedido pedido) {
        String sql = "INSERT INTO pedido (cliente_id, valor_total) VALUES (?, ?)";
        try {
            super.abrirConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pedido.getClienteId());
            ps.setDouble(2, pedido.getValorTotal());
//            ps.setString(3, pedido.getDataPedido());
            ps.executeUpdate();
            System.out.println("✅ Pedido cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar pedido: " + e.getMessage());
        } finally {
            super.fecharConexao();
        }
    }

    public List<Pedido> listar() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        try {
            super.abrirConexao();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Pedido(
                        rs.getInt("pedido_id"),
                        rs.getInt("cliente_id"),
                        rs.getDouble("valor_total"),
                        rs.getString("data_pedido")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pedidos: " + e.getMessage());
        } finally {
            super.fecharConexao();
        }
        return lista;
    }

    public void atualizar(Pedido pedido) {
        String sql = "UPDATE pedido SET cliente_id=?, valor_total=?, data_pedido=? WHERE pedido_id=?";
        try {
            super.abrirConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pedido.getClienteId());
            ps.setDouble(2, pedido.getValorTotal());
            ps.setString(3, pedido.getDataPedido());
            ps.setInt(4, pedido.getPedidoId());
            ps.executeUpdate();
            System.out.println("✅ Pedido atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pedido: " + e.getMessage());
        } finally {
            super.fecharConexao();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM pedido WHERE pedido_id=?";
        try {
            super.abrirConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Pedido excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir pedido: " + e.getMessage());
        } finally {
            super.fecharConexao();
        }
    }
}
