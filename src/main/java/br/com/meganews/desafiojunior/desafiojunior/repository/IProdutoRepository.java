package br.com.meganews.desafiojunior.desafiojunior.repository;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;

public interface IProdutoRepository extends IBuscaProdutoRepository {
    void insert(Produtos produto);

    int atualizar(Produtos produto);

    void salvar(Produtos produto);

    void excluir(Produtos produto);

    void excluirTudo(Produtos produto);

    void excluirTudoGerenciaCarga(Produtos produto);

    void DesabilitaProduto();
}
