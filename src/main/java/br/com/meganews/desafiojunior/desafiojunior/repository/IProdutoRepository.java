package br.com.meganews.desafiojunior.desafiojunior.repository;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;

public interface IProdutoRepository extends IBuscaProdutoRepository {

    void insert(Produtos produto);

    void excluirTudo(Produtos produto);

}
