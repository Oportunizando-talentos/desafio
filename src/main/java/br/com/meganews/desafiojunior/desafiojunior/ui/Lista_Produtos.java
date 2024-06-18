package br.com.meganews.desafiojunior.desafiojunior.ui;

import br.com.meganews.desafiojunior.desafiojunior.model.ProdutoZerado;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.repository.IBuscaProdutoRepository;
import br.com.meganews.desafiojunior.desafiojunior.repository.ProdutoRepository;
import br.com.meganews.desafiojunior.desafiojunior.repository.ProdutoZeradoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

public class Lista_Produtos implements Initializable {


    @FXML
    private ListView<Produto> myListWiew;

    @FXML
    private Label label;

    IBuscaProdutoRepository produtoRepository;


    String data_formatada, hora_formatada;

    private static final Locale LOCAL = new Locale("pt", "BR");

    private Connection connection;

    private ObservableList<Produto> produtoObservableList;

    public Lista_Produtos(Connection dbConnection) {


        connection = dbConnection;

        produtoObservableList = FXCollections.observableArrayList();

        ProdutoRepository p = new ProdutoRepository(connection);
        List<Produtos> list = p.buscarProduto(null, null, null);

        List<Produto> collect = list.stream().map(Produto::new).toList();

        produtoObservableList.addAll(collect);

    }


    @FXML
    protected void onAttulizaButtonClick() {


        StringBuilder resultado = new StringBuilder();
        String linha;
        int code = 0;
        boolean erro = false;

        try {
            URL urlNet = new URL("http://191.252.65.184/comercial/Produto/ServicoProduto.svc/ConsultarProduto/1");
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
                ProdutoZeradoRepository pzerado = new ProdutoZeradoRepository(connection);
                ProdutoZerado p = new ProdutoZerado();

                pzerado.excluirTudoProdutoZerado(p);

                buscarProdutoZerado();

                ProdutoRepository dbPro = new ProdutoRepository(connection);
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
        } catch (JSONException e) {
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
            produtoRepository = new ProdutoRepository(connection);
            List<Produtos> registroId = produtoRepository.buscarProdutoZerado("0");
            if (!registroId.isEmpty()) {
                for (int idP = 0; idP < registroId.size(); idP++) {
                    var produtoZerado = new ProdutoZeradoRepository(connection);
                    ProdutoZerado prodZ = new ProdutoZerado(registroId.get(idP).getCodigoDeBarra());
                    produtoZerado.insertProdutoZerado(prodZ);
                }
            }
        } catch (Exception ex) {

            ex.printStackTrace();
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