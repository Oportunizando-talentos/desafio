package br.com.meganews.desafiojunior.desafiojunior.repository;


import br.com.meganews.desafiojunior.desafiojunior.model.ProdutoZerado;

import java.sql.Connection;

public class ProdutoZeradoRepository {

    private Connection sqlConnection;

    public ProdutoZeradoRepository(Connection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }


    public void excluirTudoProdutoZerado(ProdutoZerado p) {

    }

    public void insertProdutoZerado(ProdutoZerado prodZ) {

    }
}
