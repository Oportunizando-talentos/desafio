package br.com.meganews.desafiojunior.desafiojunior.service;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.repository.IProdutoRepository;

import java.util.List;

public class MockRepository implements IProdutoRepository {
    private List<Produtos> produtos;

    public MockRepository(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    @Override
    public List buscarProduto(String filtro, String filtro2, String chkGrupo) {
        return produtos;
    }

    @Override
    public List buscarProdutoZerado(String filtro) {
        return List.of();
    }

    @Override
    public void insert(Produtos produto) {
        produtos.add(produto);
    }

    @Override
    public void excluirTudo(Produtos produto) {

    }

    @Override
    public boolean tabelaVazia() {
        return produtos.isEmpty();
    }
}
