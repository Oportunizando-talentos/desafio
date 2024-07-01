package br.com.meganews.desafiojunior.desafiojunior.repository;

import br.com.meganews.desafiojunior.desafiojunior.exceptions.RemoteConnectionException;
import br.com.meganews.desafiojunior.desafiojunior.infra.BancoDeDados;
import br.com.meganews.desafiojunior.desafiojunior.infra.Consulta;
import br.com.meganews.desafiojunior.desafiojunior.infra.DBConexao;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.service.MockConsulta;
import br.com.meganews.desafiojunior.desafiojunior.service.ServiceListaProdutos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProdutoRepositoryTest {

    @Test
    void buscarProdutoComFiltro() throws SQLException {
        Produtos produtoNoBanco = new Produtos(1, "12398173", "0");

        DBConexao dbConexao = new DBConexao("jdbc:h2:mem:buscaFiltro:", "sa", "");

        new BancoDeDados(dbConexao.dbConnection()).onCreate();

        String filtro = "0";

        ProdutoRepository produtoRepository = new ProdutoRepository(
                dbConexao.dbConnection()
        );

        produtoRepository.insert(produtoNoBanco);

        List<Produtos> produtos = produtoRepository
                .buscarProduto(filtro, null, null);

        assertEquals(produtos.getFirst(), produtoNoBanco);

    }

    @Test
    void buscarProdutoSemFiltro() throws SQLException {
        Produtos produtoNoBanco = new Produtos(1, "12398173", "0");

        DBConexao dbConexao = new DBConexao("jdbc:h2:mem:buscaSemFiltro:", "sa", "");

        new BancoDeDados(dbConexao.dbConnection()).onCreate();

        ProdutoRepository prodRepositorio = new ProdutoRepository(dbConexao.dbConnection());

        prodRepositorio.insert(produtoNoBanco);

        List<Produtos> Listaprodutos = prodRepositorio.buscarProduto(null, null, null);

        assertEquals(Listaprodutos.getFirst(), produtoNoBanco);
    }

    @Test
    void excecaoQuandoErroNoBancoTabelaVazia() throws SQLException {
        // caminho invalido
        DBConexao dbConexao = new DBConexao("jdbc:h2:mem:", "sa", "");
        new BancoDeDados(dbConexao.dbConnection()).onCreate();

        ProdutoRepository produtoRepository = new ProdutoRepository(dbConexao.dbConnection());

        assertThrows(RemoteConnectionException.class, produtoRepository::tabelaVazia);
    }

    @Test
    void excecaoQuandoErroNoBancoAoInserir() throws SQLException {
        Produtos produto = new Produtos(1, "12312412", "123");
        Produtos produto2 = new Produtos(1, "12312412", "123");

        DBConexao dbConexao = new DBConexao("jdbc:h2:mem:erroProduto", "sa", "");

        new BancoDeDados(dbConexao.dbConnection()).onCreate();

        ProdutoRepository produtoRepository = new ProdutoRepository(dbConexao.dbConnection());

        produtoRepository.insert(produto);
        produtoRepository.insert(produto2);

        PreparedStatement statement = dbConexao
                .dbConnection()
                .prepareStatement("SELECT count(*) from TB_PRODUTO;");

        ResultSet rs = statement.executeQuery();

        rs.next();

        int fetchSize = rs.getInt(1);

        assertEquals(fetchSize, 1);
    }

    @Test
    void excecaoQuandoErroNoBancoAoBuscarProduto() throws SQLException {
        DBConexao dbConexao = new DBConexao("jdbc:h2:mem:", "sa", "");

        new BancoDeDados(dbConexao.dbConnection()).onCreate();

        ProdutoRepository produtoRepository = new ProdutoRepository(dbConexao.dbConnection());

        Assertions.assertThrows(RemoteConnectionException.class, () ->
                produtoRepository.buscarProduto(null, null, null));

    }
}