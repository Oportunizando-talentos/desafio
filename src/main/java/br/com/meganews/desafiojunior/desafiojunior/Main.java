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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.http.HttpClient;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;


public class Main extends Application {
    private final static Logger logger = LogManager.getLogger(Main.class);

    @Override
    public void start(Stage stage) throws IOException {
        logger.error("Inicou!");

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Connection dbConnection;
        try {
            dbConnection = new DBConexao("jdbc:postgresql://localhost:5432/tabelas",
                    "admin",
                    "admin").dbConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            new BancoDeDados(dbConnection).onCreate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //"http://191.252.65.184/comercial/Produto/ServicoProduto.svc/ConsultarProduto/1"

        String url = "http://192.168.10.97:8081/";

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(60))
                .build();

        Consulta consulta = new Consulta(url, httpClient);

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