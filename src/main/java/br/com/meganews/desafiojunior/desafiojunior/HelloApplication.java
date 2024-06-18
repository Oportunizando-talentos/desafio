package br.com.meganews.desafiojunior.desafiojunior;

import br.com.meganews.desafiojunior.desafiojunior.ui.Lista_Produtos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Connection dbConnection = dbConnection();

        new BancoDeDados(dbConnection).onCreate();

        fxmlLoader.setController(new Lista_Produtos(dbConnection));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Listar Produtos!");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
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