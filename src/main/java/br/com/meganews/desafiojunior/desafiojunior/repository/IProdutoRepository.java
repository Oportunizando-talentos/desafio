package br.com.meganews.desafiojunior.desafiojunior.repository;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;

import java.util.List;

public interface IProdutoRepository<T> {

    List<T> buscarProduto(String filtro, String filtro2, String chkGrupo);

    List<T> buscarProdutoZerado(String filtro);

    void insert(Produtos produto);

    void excluirTudo(Produtos produto);

    boolean tabelaVazia();
}
