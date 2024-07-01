package br.com.meganews.desafiojunior.desafiojunior.service;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoRepository<Produtos> {

    List<Produtos> buscarProduto(String filtro, String filtro2, String chkGrupo) ;

    void insert(br.com.meganews.desafiojunior.desafiojunior.model.Produtos produto);

//    void excluirTudo(br.com.meganews.desafiojunior.desafiojunior.model.Produtos produto);

    boolean tabelaVazia();
}
