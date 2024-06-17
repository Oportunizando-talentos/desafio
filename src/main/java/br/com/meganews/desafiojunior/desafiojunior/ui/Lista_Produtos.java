package br.com.meganews.desafiojunior.desafiojunior.ui;

import br.com.meganews.desafiojunior.desafiojunior.model.Grupo;
import br.com.meganews.desafiojunior.desafiojunior.model.ItensPedido;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.repository.GrupoRepository;
import br.com.meganews.desafiojunior.desafiojunior.repository.IBuscaProdutoRepository;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javax.swing.text.html.FormView;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Lista_Produtos implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private ListView<Produto> myListWiew;

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


    double ipi_bc_valor, ipi_valor, icms_aliquota, icms_bc_valor, icms_bc_por, icms_st_bc_por,
            icms_valor, icms_st_aliquota, icms_st_bc_valor, mva, icms_st_valor, fcp, reducao_bc;

    private int index= 0;

    private int top = 0;


    private static final Locale LOCAL = new Locale("pt","BR");

    private int tipoPreco;

    private String msg;
    @FXML
    protected FormView hellofForm;

    private ObservableList<Produto> produtoObservableList;

    public Lista_Produtos(String Msg) {

        msg= Msg;

        produtoObservableList = FXCollections.observableArrayList();
        produtoObservableList.add(new Produto("00000",
                "teste",
                "",
                "",
                "",
                "teste",
                "10",
                BigDecimal.TEN,
                BigDecimal.ONE));


        produtoObservableList.add(new Produto("01000",
                "teste",
                "",
                "",
                "",
                "teste",
                "10",
                BigDecimal.TEN,
                BigDecimal.ONE));

        try {
            CarregaInformacoesExtras();
            ConfiguraEditPesquisa();
            ConfiguraSeBotaoSalvarHabilitado(habilitar);
        }catch (Exception ex){
            ex.getStackTrace();
         //   Util.showToast(this, "Erro: "+ ex.getMessage());
        }

    }

    private void CarregaInformacoesExtras() {


    }


    private void ConfiguraEditPesquisa() {


    }


    private void ConfiguraSeBotaoSalvarHabilitado(String habilitar) {

    }


    @FXML
    protected void onHelloButtonClick() {

        Platform.exit(); // Encerra a plataforma JavaFX
        System.exit(0);  // Encerra a aplicação Java

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myListWiew.setItems(produtoObservableList);
        myListWiew.setCellFactory(myListWiew -> new ProdutoListViewCell());
    }
}