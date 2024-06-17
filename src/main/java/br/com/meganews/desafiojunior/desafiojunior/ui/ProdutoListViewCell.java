package br.com.meganews.desafiojunior.desafiojunior.ui;

import br.com.meganews.desafiojunior.desafiojunior.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;

public class ProdutoListViewCell extends ListCell<Produto> {

    @FXML
    private Label label2;

    @FXML
    private Label label4;

    @FXML
    private GridPane gridPane;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Produto produto, boolean empty) {
        super.updateItem(produto, empty);

        if(empty || produto == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                URL resource = HelloApplication.class.getResource("list-cell.fxml");
                mLLoader = new FXMLLoader(resource);
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            label2.setText(String.valueOf(produto.getCodigo()));
            label4.setText(produto.getProduto());

            setText(null);
            setGraphic(gridPane);
        }

    }
}