package br.com.meganews.desafiojunior.desafiojunior.ui;

import br.com.meganews.desafiojunior.desafiojunior.model.Grupo;
import br.com.meganews.desafiojunior.desafiojunior.model.ItensPedido;
import br.com.meganews.desafiojunior.desafiojunior.model.ProdutoZerado;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.repository.GrupoRepository;
import br.com.meganews.desafiojunior.desafiojunior.repository.IBuscaProdutoRepository;
import br.com.meganews.desafiojunior.desafiojunior.repository.ProdutoRepository;
import br.com.meganews.desafiojunior.desafiojunior.repository.ProdutoZeradoRepository;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.text.html.FormView;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Lista_Produtos implements Initializable {


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

    private int index = 0;

    private int top = 0;


    private static final Locale LOCAL = new Locale("pt", "BR");

    private int tipoPreco;

    private String msg;
    @FXML
    protected FormView hellofForm;

    private Connection connection;

    private ObservableList<Produto> produtoObservableList;

    public Lista_Produtos(Connection dbConnection) {



        connection = dbConnection;

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
        } catch (Exception ex) {
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

        Platform.exit();
        System.exit(0);

    }


    @FXML
    protected void onAttulizaButtonClick() {


        StringBuilder resultado = new StringBuilder();
        String linha;
        int code = 0;
        boolean erro = false;

        try {
            URL urlNet = new URL("http://191.252.65.184/comercial/ProdutoCarga/ServicoProdutoCarga.svc/ConsultarProdutoCarga/1");
            HttpURLConnection con = (HttpURLConnection) urlNet.openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.connect();
            InputStream inp = con.getInputStream();
            code = con.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inp));
            while ((linha = bufferedReader.readLine()) != null) {
                try {
                    resultado.append("{" + "\"Produto\"" + ":");
                    resultado.append(linha.trim());
                    resultado.append("}");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            erro = true;
        }
        try {
            if (code == 200) {
                ProdutoZeradoRepository pzerado = new ProdutoZeradoRepository();
                ProdutoZerado p = new ProdutoZerado();
                pzerado.excluirTudoProdutoZerado(p);

                buscarProdutoZerado();

                ProdutoRepository dbPro = new ProdutoRepository();
                Produtos pro = new Produtos();
                dbPro.excluirTudo(pro);

                Produtos produtos = new Produtos();

                JSONObject jsonRootObject = new JSONObject(resultado.toString());
                JSONArray jsonArray = jsonRootObject.getJSONArray("Produto");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    produtos.setIdProduto(jsonObject.optLong("idProduto"));
                    produtos.setCodigoDeBarra(jsonObject.optString("codigoBarraProduto"));
                    produtos.setDescricao(jsonObject.optString("descricaoProduto"));
                    produtos.setReferencia(jsonObject.optString("referenciaProduto"));
                    produtos.setIdMarca(jsonObject.optString("idMarca"));
                    produtos.setUnidade(jsonObject.optString("unidadeProduto"));
                    produtos.setPrecoUnidade(jsonObject.optString("precoUnidadeProduto"));
                    produtos.setAplicacao(jsonObject.optString("aplicacaoProduto"));
                    produtos.setIdGrupo(jsonObject.optString("idGrupo"));
                    produtos.setDetalheProduto(jsonObject.optString("detalheProduto"));
                    produtos.setTabelaPreco(jsonObject.optString("precoTabelaProduto"));
                    produtos.setPreco(jsonObject.optString("precoProduto"));
                    produtos.setEstoqueAtual(jsonObject.optString("estoqueAtualProduto"));
                    produtos.setFotoProduto(jsonObject.optString("fotoProduto"));
                    produtos.setDataUltimaEntradaEstoque(jsonObject.optString("dataUltimaEntradaEstoque"));
                    produtos.setQuantidadeFracioanl(jsonObject.optString("qtdFracionalProduto"));
                    produtos.setPromocao(jsonObject.optString("promocao"));
                    produtos.setPrecoAnterior(jsonObject.optString("precoAnterior"));
                    produtos.setPrecoPF(jsonObject.optString("precoPF"));
                    produtos.setPrecoPJ(jsonObject.optString("precoPJ"));
                    produtos.setQuantEmbalagem(jsonObject.optString("quantEmbalagem"));
                    produtos.setCst(jsonObject.optString("cst"));
                    produtos.setIcms_aliquota(jsonObject.optString("icms_aliquota"));
                    produtos.setIcms_bc_valor(jsonObject.optString("icms_bc_valor"));
                    produtos.setIcms_valor(jsonObject.optString("icms_valor"));
                    produtos.setMva(jsonObject.optString("mva"));
                    produtos.setIcms_st_bc_valor(jsonObject.optString("icms_st_bc_valor"));
                    produtos.setIcms_st_valor(jsonObject.optString("icms_st_valor"));
                    produtos.setMva_pf(jsonObject.optString("mva_pf"));
                    produtos.setIcms_st_bc_valor_pf(jsonObject.optString("icms_st_bc_valor_pf"));
                    produtos.setIcms_st_valor_pf(jsonObject.optString("icms_st_valor_pf"));
                    produtos.setIpi_aliquota(jsonObject.optString("ipi_aliquota"));
                    produtos.setIpi_bc_valor(jsonObject.optString("ipi_bc_valor"));
                    produtos.setIpi_valor(jsonObject.optString("ipi_valor"));
                    produtos.setFcp(jsonObject.optString("fcp"));
                    produtos.setReducaoBC(jsonObject.optString("reducaoBC"));
                    produtos.setIcms_bc_por(jsonObject.optString("icms_bc_por"));
                    produtos.setIcms_st_bc_por(jsonObject.optString("icms_st_bc_por"));

                    if (jsonObject.optString("idCarga").isEmpty()) {
                        produtos.setIdCarga("");
                    } else {
                        produtos.setIdCarga(jsonObject.optString("idCarga"));
                    }

                    Produtos prod = new Produtos(produtos.getIdProduto(), produtos.getCodigoDeBarra(), produtos.getDescricao(), produtos.getReferencia(),
                            produtos.getIdMarca(), produtos.getUnidade(), produtos.getPrecoUnidade(), produtos.getAplicacao(),
                            produtos.getIdGrupo(), produtos.getDetalheProduto(), produtos.getTabelaPreco(), produtos.getPreco(),
                            produtos.getEstoqueAtual(), produtos.getFotoProduto(), produtos.getDataUltimaEntradaEstoque(),
                            produtos.getQuantidadeFracioanl(), produtos.getPromocao(), produtos.getPrecoAnterior(),
                            produtos.getPrecoPF(), produtos.getPrecoPJ(), produtos.getQuantEmbalagem(), produtos.getCst(), produtos.getIcms_aliquota(),
                            produtos.getIcms_bc_valor(), produtos.getIcms_valor(), produtos.getMva(), produtos.getIcms_st_bc_valor(), produtos.getIcms_st_valor(),
                            produtos.getMva_pf(), produtos.getIcms_st_bc_valor_pf(), produtos.getIcms_st_valor_pf(), produtos.getIpi_aliquota(), produtos.getIpi_bc_valor(),
                            produtos.getIpi_valor(), produtos.getFcp(), produtos.getReducaoBC(), produtos.getIcms_bc_por(), produtos.getIcms_st_bc_por(), "", produtos.getIdCarga());
                    dbPro.insert(prod);


                    dataFormat();

                }
            } else {
                erro = true;
            }
        }
        catch (JSONException e) {
             erro = true;
        }
        resultado.toString();
    }


    public void dataFormat() {
        SimpleDateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hFormat = new SimpleDateFormat("HH:mm");
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();

        data_formatada = dtFormat.format(data_atual);
        hora_formatada = hFormat.format(data_atual);
    }



    public void buscarProdutoZerado() {
        try {
            produtoRepository = new ProdutoRepository();
            List<Produtos> registroId = produtoRepository.buscarProdutoZerado("0");
            if (registroId.size() != 0) {
                for (int idP = 0; idP < registroId.size(); idP++) {
                    var produtoZerado = new ProdutoZeradoRepository();
                    ProdutoZerado prodZ = new ProdutoZerado(registroId.get(idP).getCodigoDeBarra());
                    produtoZerado.insertProdutoZerado(prodZ);
                }
            }
        }catch (Exception ex){

        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myListWiew.setItems(produtoObservableList);
        myListWiew.setCellFactory(myListWiew -> new ProdutoListViewCell());
    }
}