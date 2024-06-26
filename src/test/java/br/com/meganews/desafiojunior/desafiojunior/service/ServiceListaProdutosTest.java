package br.com.meganews.desafiojunior.desafiojunior.service;

import br.com.meganews.desafiojunior.desafiojunior.infra.BancoDeDados;
import br.com.meganews.desafiojunior.desafiojunior.infra.DBConexao;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceListaProdutosTest {

    @Test
    void atualizarQuandoListaVazia() {
        List<Produtos> produtosListRepository = new ArrayList<>();
        List<Produtos> produtosListConsulta = new ArrayList<>();


        ServiceListaProdutos serviceListaProdutos = new ServiceListaProdutos(
                new MockRepository(produtosListRepository),
                new MockConsulta(produtosListConsulta)
        );

        Produtos produto = new Produtos(1, "150");

        produtosListConsulta.add(produto);

        serviceListaProdutos.atualizar();

        assertFalse(produtosListRepository.isEmpty());
        assertEquals(produto, produtosListRepository.getFirst());
    }

    @Test
    void atualizarQuandoListaNaoVazia() {
        List<Produtos> produtosListaRepositorio = new ArrayList<>();
        List<Produtos> produtosListaConsulta = new ArrayList<>();

        ServiceListaProdutos serviceListaProdutos = new ServiceListaProdutos(
                new MockRepository(produtosListaRepositorio),
                new MockConsulta(produtosListaConsulta)
        );

        Produtos produtoRepositorio = new Produtos(1, "150");
        Produtos produtoConsulta = new Produtos(2, "250");

        produtosListaRepositorio.add(produtoRepositorio);
        produtosListaConsulta.add(produtoConsulta);
        serviceListaProdutos.atualizar();

        assertFalse(produtosListaRepositorio.isEmpty());
        assertNotEquals(produtosListaConsulta, produtosListaRepositorio.getFirst());
    }

    @Test
    void listarProdutos() {
        List<Produtos> produtosListaRepositorio = new ArrayList<>();
        List<Produtos> produtosListaConsulta = new ArrayList<>();

        Produtos produtoRepositorio = new Produtos(1, "150");
        Produtos produtoRepositorio1 = new Produtos(3, "350");
        Produtos produtoConsulta = new Produtos(2, "250");

        produtosListaRepositorio.add(produtoRepositorio);
        produtosListaRepositorio.add(produtoRepositorio1);
        produtosListaConsulta.add(produtoConsulta);

        List<Produtos> produtos = new ServiceListaProdutos(
                new MockRepository(produtosListaRepositorio),
                new MockConsulta(produtosListaConsulta)
        ).listarProdutos();

        assertEquals(produtos.size(), produtosListaRepositorio.size());
    }

    @Test
    void atualizarQuandoListaVaziaIntegracao() {
        List<Produtos> produtosListaConsulta = new ArrayList<>();

        DBConexao dbConexao = new DBConexao("jdbc:h2:mem:test", "sa", "");

        new BancoDeDados(dbConexao.dbConnection()).onCreate();

        ServiceListaProdutos serviceListaProdutos = new ServiceListaProdutos(
                new ProdutoRepository(dbConexao.dbConnection()),
                new MockConsulta(produtosListaConsulta)
        );

        Produtos produtoConsulta = new Produtos(1, "1234566789", "250");

        produtosListaConsulta.add(produtoConsulta);

        serviceListaProdutos.atualizar();

        assertEquals(produtoConsulta, serviceListaProdutos.listarProdutos().getFirst());
    }

    @Test
    void atualizarQuandoListaNaoVaziaIntegracao() {
        List<Produtos> produtosListaConsulta = new ArrayList<>();

        DBConexao dbConexao = new DBConexao("jdbc:h2:mem:atualizarQuandoListaNaoVaziaIntegracao", "sa", "");

        new BancoDeDados(dbConexao.dbConnection()).onCreate();

        Produtos produtoConsulta = new Produtos(2, "1234566789", "250");

        produtosListaConsulta.add(produtoConsulta);

        ServiceListaProdutos serviceListaProdutos = new ServiceListaProdutos(
                new ProdutoRepository(dbConexao.dbConnection()),
                new MockConsulta(produtosListaConsulta)
        );

        serviceListaProdutos.atualizar();

        assertFalse(serviceListaProdutos.listarProdutos().isEmpty());
        assertEquals(produtosListaConsulta, serviceListaProdutos.listarProdutos());
    }

}