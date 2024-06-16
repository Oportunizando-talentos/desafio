package br.com.meganews.desafiojunior.desafiojunior;

import br.com.meganews.desafiojunior.desafiojunior.ui.Lista_Produtos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        fxmlLoader.setController(new Lista_Produtos("teste"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Listar Produtos!");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}