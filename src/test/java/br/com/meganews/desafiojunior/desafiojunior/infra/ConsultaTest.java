package br.com.meganews.desafiojunior.desafiojunior.infra;

import br.com.meganews.desafiojunior.desafiojunior.exceptions.RemoteConnectionException;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


class ConsultaTest {

    @Test
    void getProdutos() {
        String url = "http://localhost";

        try (HttpClient httpClient = Mockito.mock(HttpClient.class)) {
            HttpResponse<String> response = Mockito.mock(HttpResponse.class);
            Mockito.when(response.statusCode()).thenReturn(200);
            Mockito.when(response.body()).thenReturn(
                    "[\n" +
                            "\t{\n" +
                            "\t\t\"aplicacaoProduto\": \"\",\n" +
                            "\t\t\"ativo\": null,\n" +
                            "\t\t\"caracteristicas\": \"\",\n" +
                            "\t\t\"codigoBarraProduto\": \"0000000000702\",\n" +
                            "\t\t\"cst\": \"060\",\n" +
                            "\t\t\"dataUltimaEntradaEstoque\": \"01\\\\/11\\\\/2023\",\n" +
                            "\t\t\"descricaoProduto\": \"ACAFRAO DA TERRA SACHET VIA NUTRY 24X50G\",\n" +
                            "\t\t\"detalheProduto\": \"0\",\n" +
                            "\t\t\"estoqueAtualProduto\": 8,\n" +
                            "\t\t\"fcp\": 0,\n" +
                            "\t\t\"fornecedorProduto\": \"E. PETEAN PEREIRA CARDOSO \",\n" +
                            "\t\t\"icms_aliquota\": 0,\n" +
                            "\t\t\"icms_bc_por\": 0,\n" +
                            "\t\t\"icms_bc_valor\": 0,\n" +
                            "\t\t\"icms_st_bc_por\": 0,\n" +
                            "\t\t\"icms_st_bc_valor\": 0,\n" +
                            "\t\t\"icms_st_bc_valor_pf\": 0,\n" +
                            "\t\t\"icms_st_valor\": 0,\n" +
                            "\t\t\"icms_st_valor_pf\": 0,\n" +
                            "\t\t\"icms_valor\": 0,\n" +
                            "\t\t\"idCarga\": 0,\n" +
                            "\t\t\"idGrupo\": 1,\n" +
                            "\t\t\"idMarca\": 1,\n" +
                            "\t\t\"idProduto\": 1,\n" +
                            "\t\t\"idVendedor\": 0,\n" +
                            "\t\t\"ipi_aliquota\": 0,\n" +
                            "\t\t\"ipi_bc_valor\": 0,\n" +
                            "\t\t\"ipi_valor\": 0,\n" +
                            "\t\t\"mva\": 0,\n" +
                            "\t\t\"mva_pf\": 0,\n" +
                            "\t\t\"precoAnterior\": 0,\n" +
                            "\t\t\"precoPF\": 0,\n" +
                            "\t\t\"precoPJ\": 0,\n" +
                            "\t\t\"precoProduto\": 78.62,\n" +
                            "\t\t\"precoTabelaProduto\": 78.62,\n" +
                            "\t\t\"precoUnidadeProduto\": 0,\n" +
                            "\t\t\"promocao\": \"N\",\n" +
                            "\t\t\"qtdFracionalProduto\": 0,\n" +
                            "\t\t\"quantEmbalagem\": 24,\n" +
                            "\t\t\"reducaoBC\": 0,\n" +
                            "\t\t\"referenciaProduto\": \"\",\n" +
                            "\t\t\"unidadeProduto\": \"CX\"\n" +
                            "\t}\n" +
                            "]"
            );

            Mockito.when(httpClient.send(
                    Mockito.any(HttpRequest.class),
                    Mockito.any(HttpResponse.BodyHandler.class))
            ).thenReturn(response);

            Consulta consulta = new Consulta(url, httpClient);

            List<Produtos> produtos = consulta.getProdutos();
            Assertions.assertFalse(produtos.isEmpty());
            Assertions.assertEquals("ACAFRAO DA TERRA SACHET VIA NUTRY 24X50G", produtos.getFirst().getDescricao());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getProdutosQuandoIOException() {
        String url = "http://localhost";

        try (HttpClient httpClient = Mockito.mock(HttpClient.class)) {

            Mockito.when(httpClient.send(Mockito.any(), Mockito.any())).thenThrow(IOException.class);

            Consulta consulta = new Consulta(url, httpClient);
            Assertions.assertThrows(RemoteConnectionException.class, consulta::getProdutos);


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
        @Test
    void excecaoQuandoErroNaConexao() {
        String url = "";

        HttpClient httpClient = Mockito.mock(HttpClient.class);

        Consulta consulta = new Consulta(url, httpClient);
        Assertions.assertThrows(Exception.class, consulta::getProdutos);
    }

    @Test
    void excecaoQuandoStatusCodeNaoOK() throws IOException, InterruptedException {
        String url = "http://localhost";

        HttpClient httpClient = Mockito.mock(HttpClient.class);

        HttpResponse<String> response = Mockito.mock(HttpResponse.class);

        Mockito.when(response.statusCode()).thenReturn(500);

        Mockito.when(httpClient.send(
                Mockito.any(HttpRequest.class),
                Mockito.any(HttpResponse.BodyHandler.class))
        ).thenReturn(response);

        Consulta consulta = new Consulta(url, httpClient);
        Assertions.assertThrows(RemoteConnectionException.class, consulta::getProdutos);
    }

    @Test
    void excecaoAoDesserializarJson() throws IOException, InterruptedException {
        String url = "http://localhost";

        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse<String> response = Mockito.mock(HttpResponse.class);

        Mockito.when(response.statusCode()).thenReturn(200);
        Mockito.when(response.body()).thenReturn(
                "[\n" +
                        "\t{\n" +
                        "\t\t\"aplicacaoProduto\": \"\",\n"
        );

        Mockito.when(httpClient.send(
                Mockito.any(HttpRequest.class),
                Mockito.any(HttpResponse.BodyHandler.class))
        ).thenReturn(response);

        Consulta consulta = new Consulta(url, httpClient);

        Assertions.assertThrows(Exception.class, consulta::getProdutos);
    }
}