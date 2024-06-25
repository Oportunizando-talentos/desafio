package br.com.meganews.desafiojunior.desafiojunior.service;

import br.com.meganews.desafiojunior.desafiojunior.infra.IConsulta;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.repository.IProdutoRepository;

import java.util.List;

public class ServiceListaProdutos {
    private IProdutoRepository produtoRepository;
    private IConsulta consultaAPI;

    public ServiceListaProdutos(IProdutoRepository produtoRepository, IConsulta consultaAPI) {
        this.produtoRepository = produtoRepository;
        this.consultaAPI = consultaAPI;
        atualizar();
    }

    private void inserirProdutos() {
        List<Produtos> produtos = consultaAPI.getProdutos();
        produtos.forEach(produto -> produtoRepository.insert(produto));
    }

    public void atualizar() {
        if (produtoRepository.tabelaVazia()) {
            inserirProdutos();
        }
    }

    public List<Produtos> listarProdutos() {
        return produtoRepository.buscarProduto(null, null, null);
    }
}
