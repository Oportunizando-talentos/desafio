package br.com.meganews.desafiojunior.desafiojunior.repository;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;

import java.util.List;

public class ProdutoRepository implements IProdutoRepository, IBuscaProdutoRepository, IProdutoEstoqueRepository {
    public ProdutoRepository() {
    }

    @Override
    public boolean ExisteProduto(String idProduto) {
        return false;
    }

    @Override
    public List buscarProduto(String filtro, String filtro2, String chkGrupo) {
        return List.of();
    }

    @Override
    public List buscarProdutoNaPromocao(String filtro, String filtro2, String chkGrupo) {
        return List.of();
    }

    @Override
    public List buscarProdutoZerado(String filtro) {
        return List.of();
    }

    @Override
    public String buscarPrecoVenda(String filtro, String tipoPessoa) {
        return "";
    }

    @Override
    public int atualizarEstoque(Produtos produto) {
        return 0;
    }

    @Override
    public int atualizarEstoqueReposto(Produtos produto) {
        return 0;
    }

    @Override
    public String buscarEstProduto(String filtro) {
        return "";
    }

    @Override
    public String buscarPrecoUniProduto(String filtro) {
        return "";
    }

    @Override
    public void insert(Produtos produto) {

    }

    @Override
    public int atualizar(Produtos produto) {
        return 0;
    }

    @Override
    public void salvar(Produtos produto) {

    }

    @Override
    public void excluir(Produtos produto) {

    }

    @Override
    public void excluirTudo(Produtos produto) {

    }

    @Override
    public void excluirTudoGerenciaCarga(Produtos produto) {

    }

    @Override
    public void DesabilitaProduto() {

    }
}
