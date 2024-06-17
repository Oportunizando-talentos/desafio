package br.com.meganews.desafiojunior.desafiojunior.repository;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;

public interface IProdutoEstoqueRepository {
    int atualizarEstoque(Produtos produto);

    int atualizarEstoqueReposto(Produtos produto);

    String buscarEstProduto(String filtro);
}
