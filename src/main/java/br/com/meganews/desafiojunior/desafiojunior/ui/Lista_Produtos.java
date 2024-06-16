package br.com.meganews.desafiojunior.desafiojunior.ui;

import br.com.meganews.desafiojunior.desafiojunior.model.Grupo;
import br.com.meganews.desafiojunior.desafiojunior.model.ItensPedido;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.repository.GrupoRepository;
import br.com.meganews.desafiojunior.desafiojunior.repository.IBuscaProdutoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Lista_Produtos {
    @FXML
    private Label welcomeText;

    IBuscaProdutoRepository produtoRepository;

    List<Produtos> registro;

    ArrayList<Produtos> dadosListProd;

    ArrayList<ItensPedido> dadosIt;

    String habilitar;

    Produtos itemPosicao;

    String data_formatada, hora_formatada;

    double somaAcumulo = 0;

    double percDesconto;

    NumberFormat formato1;

    DecimalFormat formato2;

    double totalItem;

    double valorDescontoitem;

    double resultado;

    double sTotal;

    String caracterBusca, caracterBusca2, caracterGrupo, CNPJ;

    long idPedido = 0;

    GrupoRepository dbGrupo;

    ArrayList<Grupo> opcoesGrupo;

    ArrayList<Grupo> listGrupo;

    String DescricaoGrupo;

    double bigPreco;

    String listaResumida;

    double PrecoTabela = 0;

    double DescontoPlanoValor = 0;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}