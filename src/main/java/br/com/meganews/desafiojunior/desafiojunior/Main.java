package br.com.meganews.desafiojunior.desafiojunior;

import br.com.meganews.desafiojunior.desafiojunior.ui.Lista_Produtos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Connection dbConnection = dbConnection();

        new BancoDeDados(dbConnection).onCreate();

        if (!tabelaCheia(dbConnection)) new Consulta(dbConnection).init();

        fxmlLoader.setController(new Lista_Produtos(dbConnection));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Listar Produtos!");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    private boolean tabelaCheia(Connection db){

        String sql = "SELECT COUNT(*) AS total FROM TB_PRODUTO";
        try {
            PreparedStatement pstmt = db.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt("total") > 0) return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    private Connection dbConnection(){

        String jdbcUrl = "jdbc:postgresql://localhost:5432/tabelas";
        String username = "admin";
        String password = "admin";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}