package ucb.aplicacao.dao;

import ucb.aplicacao.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends BaseDAO {

    public void inserir(Cliente cliente) {
        try {
            abrirConexao();
            String sql = "INSERT INTO Cliente (nome, email, senha, cidade, endereco, numero, cep) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getNumero());
            stmt.setString(7, cliente.getCep());
            stmt.executeUpdate();
            System.out.println("✅ Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            abrirConexao();
            stmt = conn.prepareStatement("SELECT * FROM Cliente");
            rs = stmt.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("cidade"),
                        rs.getString("endereco"),
                        rs.getString("numero"),
                        rs.getString("cep")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return clientes;
    }

    public void atualizar(Cliente cliente) {
        try {
            abrirConexao();
            String sql = "UPDATE Cliente SET nome=?, email=?, senha=?, cidade=?, endereco=?, numero=?, cep=? WHERE cliente_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getNumero());
            stmt.setString(7, cliente.getCep());
            stmt.setInt(8, cliente.getId());
            stmt.executeUpdate();
            System.out.println("✅ Cliente atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletar(int id) {
        try {
            abrirConexao();
            stmt = conn.prepareStatement("DELETE FROM Cliente WHERE cliente_id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("🗑️ Cliente excluído!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }
}
