package br.com.meganews.desafiojunior.desafiojunior.ui;

import br.com.meganews.desafiojunior.desafiojunior.Main;
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
    private Label label6;
    @FXML
    private Label label8;
    @FXML
    private Label label10;
    @FXML
    private Label label12;
    @FXML
    private Label label14;
    @FXML
    private Label label16;
    @FXML
    private Label label17;
    @FXML
    private Label label19;

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
                URL resource = Main.class.getResource("list-cell.fxml");
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
            label6.setText(produto.getReferencia());
            label8.setText(produto.getPromocao());
            label10.setText(produto.getMarca());
            label12.setText(produto.getGrupo());
            label14.setText(produto.getEstoque());
            label16.setText(produto.getUnidade());
            label17.setText(String.valueOf(produto.getPreco()));
            label19.setText(String.valueOf(produto.getPrecoUnidade()));
            setText(null);
            setGraphic(gridPane);
        }

    }
}