package br.com.meganews.desafiojunior.desafiojunior.repository;

import java.util.List;

public interface IBuscaProdutoRepository<T> {

    boolean ExisteProduto(String idProduto);

    List<T> buscarProduto(String filtro, String filtro2, String chkGrupo);

    List<T> buscarProdutoNaPromocao(String filtro, String filtro2, String chkGrupo);

    List<T> buscarProdutoZerado(String filtro);

    String buscarPrecoVenda(String filtro, String tipoPessoa);

    String buscarEstProduto(String filtro);

    String buscarPrecoUniProduto(String filtro);
}
