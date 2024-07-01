package br.com.meganews.desafiojunior.desafiojunior.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexao {

    private String jdbcUrl;
    private String username;
    private String password;

    public DBConexao(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public Connection dbConnection() throws SQLException{
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
