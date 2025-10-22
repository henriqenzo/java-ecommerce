package ucb.aplicacao.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ucb.aplicacao.model.Pagamento;

public class PagamentoDAO extends BaseDAO {

    public void inserir(Pagamento p) {
        String sql = "INSERT INTO pagamento (pedido_id, valor, status_pagamento) VALUES (?, ?, ?)";
        try {
            super.abrirConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getPedidoId());
            ps.setDouble(2, p.getValor());
            ps.setString(3, p.getStatus());
            ps.executeUpdate();
            System.out.println("✅ Pagamento cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar pagamento: " + e.getMessage());
        } finally {
            super.fecharConexao();
        }
    }

    public List<Pagamento> listar() {
        List<Pagamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM pagamento";
        try {
            super.abrirConexao();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Pagamento(
                        rs.getInt("pagamento_id"),
                        rs.getInt("pedido_id"),
                        rs.getDouble("valor"),
                        rs.getString("data_pagamento"),
                        rs.getString("status_pagamento")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pagamentos: " + e.getMessage());
        } finally {
            super.fecharConexao();
        }
        return lista;
    }
}
