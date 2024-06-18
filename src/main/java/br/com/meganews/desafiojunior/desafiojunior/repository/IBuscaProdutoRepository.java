package br.com.meganews.desafiojunior.desafiojunior.repository;

import java.util.List;

public interface IBuscaProdutoRepository<T> {


    List<T> buscarProduto(String filtro, String filtro2, String chkGrupo);

    List<T> buscarProdutoZerado(String filtro);


}
