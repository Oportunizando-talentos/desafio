package br.com.meganews.desafiojunior.desafiojunior.ui;

import br.com.meganews.desafiojunior.desafiojunior.model.Grupo;
import br.com.meganews.desafiojunior.desafiojunior.model.ItensPedido;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.repository.GrupoRepository;
import br.com.meganews.desafiojunior.desafiojunior.repository.IBuscaProdutoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.text.html.FormView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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


    double ipi_bc_valor, ipi_valor, icms_aliquota, icms_bc_valor, icms_bc_por, icms_st_bc_por,
            icms_valor, icms_st_aliquota, icms_st_bc_valor, mva, icms_st_valor, fcp, reducao_bc;

    private int index= 0;

    private int top = 0;


    private static final Locale LOCAL = new Locale("pt","BR");

    private int tipoPreco;

    private String msg;
    @FXML
    protected FormView hellofForm;

    public Lista_Produtos(String Msg) {

        msg= Msg;

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(msg);
    }
}