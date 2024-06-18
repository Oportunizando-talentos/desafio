package br.com.meganews.desafiojunior.desafiojunior;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.repository.ProdutoRepository;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;

public class Consulta {

     String url =  "http://191.252.65.184/comercial/Produto/ServicoProduto.svc/ConsultarProduto/1";

     private Connection connection;

    public Consulta(Connection connection) {
        this.connection = connection;
    }

    public void init(){

        try {
            String consultar = Consultar();
            Gravar(consultar);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private String Consultar() throws Exception {
        StringBuilder json = new StringBuilder("");
        try {
            URL urlNet = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlNet.openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.connect();
            var codigoResposta = con.getResponseCode();
            InputStream inp = con.getInputStream();
            InputStreamReader response = new InputStreamReader(inp, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(response);
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                json.append("{" + "\"" + "Produto" +"\"" + ":");
                json.append(linha);
                json.append("}");
            }

        } catch (Exception e) {
            throw e;
        }
        return json.toString();
    }

    private void Gravar(String resposta) throws Exception {
        ProdutoRepository dbProduto = new ProdutoRepository(connection);


        JSONObject jsonRootObjectProd;
        try {
            jsonRootObjectProd = new JSONObject(resposta);
            JSONArray jsonArrayProd = jsonRootObjectProd.optJSONArray("Produto");
            int tamanho = jsonArrayProd.length();
            for (int i = 0; i < jsonArrayProd.length(); i++) {
                JSONObject jsonObjectPro;
                jsonObjectPro = jsonArrayProd.getJSONObject(i);

                Produtos prod = new Produtos(jsonObjectPro.optLong("idProduto"),
                        jsonObjectPro.optString("codigoBarraProduto"),
                        jsonObjectPro.optString("descricaoProduto"),
                        jsonObjectPro.optString("referenciaProduto"),
                        jsonObjectPro.optString("idMarca"),
                        jsonObjectPro.optString("unidadeProduto"),
                        jsonObjectPro.optString("precoUnidadeProduto"),
                        jsonObjectPro.optString("aplicacaoProduto"),
                        jsonObjectPro.optString("idGrupo"),
                        jsonObjectPro.optString("detalheProduto"),
                        jsonObjectPro.optString("precoTabelaProduto"),
                        jsonObjectPro.optString("precoProduto"),
                        jsonObjectPro.optString("estoqueAtualProduto"),
                        jsonObjectPro.optString("fotoProduto"),
                        jsonObjectPro.optString("dataUltimaEntradaEstoque"),
                        jsonObjectPro.optString("qtdFracionalProduto"),
                        jsonObjectPro.optString("promocao"),
                        jsonObjectPro.optString("precoAnterior"),
                        jsonObjectPro.optString("precoPF"),
                        jsonObjectPro.optString("precoPJ"),
                        jsonObjectPro.optString("quantEmbalagem"),
                        jsonObjectPro.optString("cst"),
                        jsonObjectPro.optString("icms_aliquota"),
                        jsonObjectPro.optString("icms_bc_valor"),
                        jsonObjectPro.optString("icms_valor"),
                        jsonObjectPro.optString("mva"),
                        jsonObjectPro.optString("icms_st_bc_valor"),
                        jsonObjectPro.optString("icms_st_valor"),
                        jsonObjectPro.optString("mva_pf"),
                        jsonObjectPro.optString("icms_st_bc_valor_pf"),
                        jsonObjectPro.optString("icms_st_valor_pf"),
                        jsonObjectPro.optString("ipi_aliquota"),
                        jsonObjectPro.optString("ipi_bc_valor"),
                        jsonObjectPro.optString("ipi_valor"),
                        jsonObjectPro.optString("fcp"),
                        jsonObjectPro.optString("reducaoBC"),
                        jsonObjectPro.optString("icms_bc_por"),
                        jsonObjectPro.optString("icms_st_bc_por"),
                        "",
                        jsonObjectPro.optString("idCarga").isEmpty() ? "" : jsonObjectPro.optString("idCarga")
                );
                dbProduto.insert(prod);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
