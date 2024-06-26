package br.com.meganews.desafiojunior.desafiojunior.infra;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DBConexaoTest {

    private void dbConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:", "sa", "");

            ResultSet resultSet = conn.createStatement().executeQuery("SELECT 1;");

            assertTrue(resultSet.next());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}