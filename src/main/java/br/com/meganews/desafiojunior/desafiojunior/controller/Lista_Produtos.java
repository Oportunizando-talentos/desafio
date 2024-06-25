package br.com.meganews.desafiojunior.desafiojunior.controller;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.repository.IProdutoRepository;
import br.com.meganews.desafiojunior.desafiojunior.service.ServiceListaProdutos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.*;

public class Lista_Produtos implements Initializable {

    @FXML
    private ListView<Produto> myListWiew;

    @FXML
    private Label label;

    private ServiceListaProdutos serviceListaProdutos;

    IProdutoRepository produtoRepository;

    private static final Locale LOCAL = new Locale("pt", "BR");

    private ObservableList<Produto> produtoObservableList;

    public Lista_Produtos(ServiceListaProdutos serviceListaProdutos) {

        this.serviceListaProdutos = serviceListaProdutos;

        produtoObservableList = FXCollections.observableArrayList();

        List<Produtos> list = serviceListaProdutos.listarProdutos();

        List<Produto> collect = list.stream().map(Produto::new).toList();

        produtoObservableList.addAll(collect);

    }


    @FXML
    protected void onAtualizaButtonClick() {
        try {
            serviceListaProdutos.atualizar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ContaItens() {
        label.setText(String.valueOf(produtoObservableList.size()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myListWiew.setItems(produtoObservableList);
        myListWiew.setCellFactory(myListWiew -> new ProdutoListViewCell());

        ContaItens();
    }
}