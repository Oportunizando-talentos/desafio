package br.com.meganews.desafiojunior.desafiojunior.infra;

import br.com.meganews.desafiojunior.desafiojunior.exceptions.RemoteConnectionException;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.service.IConsulta;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Consulta implements IConsulta {
    private final String url;
    private final HttpClient httpClient;
    private static final Logger logger = LogManager.getLogger(Consulta.class);

    public Consulta(String url, HttpClient httpClient) {
        this.url = url;
        this.httpClient = httpClient;
    }

    public List<Produtos> getProdutos() {
        String consultar = consultar();

        logger.error("Agora nós vamos gravar!");

        return desserializarJson(consultar);
    }

    private String consultar() {

        HttpResponse<String> connection = getConnection();

        logger.error("Consulta realizada!");

        if (connection.statusCode() != 200) {

            RemoteConnectionException remoteConnectionException = new RemoteConnectionException();

            logger.error("Consulta falhou! {}",remoteConnectionException.getMessage());

            throw remoteConnectionException;
        }

        return "{" + "\"" + "Produto" + "\"" + ":" +
                connection.body() +
                "}";
    }

    private HttpResponse<String> getConnection()  {

            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            logger.error("Conectado!");

        try {
            return httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            logger.error(e.getMessage());
        }
        return new HttpResposeNull();
    }

    private List<Produtos> desserializarJson(String resposta) {
        List<Produtos> produtos = new ArrayList<>();

        JSONObject jsonRootObjectProd;
        jsonRootObjectProd = new JSONObject(resposta);
        JSONArray jsonArrayProd = jsonRootObjectProd.optJSONArray("Produto");
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
            produtos.add(prod);

            logger.error("Gravado com sucesso!");
        }
        return produtos;
    }
}
