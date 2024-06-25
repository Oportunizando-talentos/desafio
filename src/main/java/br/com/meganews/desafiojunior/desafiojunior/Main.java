package br.com.meganews.desafiojunior.desafiojunior;

import br.com.meganews.desafiojunior.desafiojunior.controller.Lista_Produtos;
import br.com.meganews.desafiojunior.desafiojunior.infra.BancoDeDados;
import br.com.meganews.desafiojunior.desafiojunior.infra.Consulta;
import br.com.meganews.desafiojunior.desafiojunior.infra.DBConexao;
import br.com.meganews.desafiojunior.desafiojunior.repository.ProdutoRepository;
import br.com.meganews.desafiojunior.desafiojunior.service.ServiceListaProdutos;
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

        Connection dbConnection = new DBConexao("jdbc:postgresql://localhost:5432/tabelas",
                "admin",
                "admin").dbConnection();

        new BancoDeDados(dbConnection).onCreate();

        Consulta consulta = new Consulta("http://191.252.65.184/comercial/Produto/ServicoProduto.svc/ConsultarProduto/1");

        ServiceListaProdutos serviceListaProdutos = new ServiceListaProdutos(new ProdutoRepository(dbConnection), consulta);

        fxmlLoader.setController(new Lista_Produtos(serviceListaProdutos));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Listar Produtos!");
        stage.setMaximized(true);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}