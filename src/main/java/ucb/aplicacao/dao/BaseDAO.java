package ucb.aplicacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO {
    protected Connection conn;
    protected PreparedStatement stmt;
    protected ResultSet rs;

    protected void abrirConexao() throws SQLException {
        conn = ConexaoBD.getConexao();
    }

    protected void fecharConexao() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
