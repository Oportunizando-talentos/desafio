package br.com.meganews.desafiojunior.desafiojunior.repository;


import br.com.meganews.desafiojunior.desafiojunior.model.ProdutoZerado;

import java.sql.Connection;
import java.sql.SQLException;

public class ProdutoZeradoRepository {

    private Connection sqlConnection;

    public ProdutoZeradoRepository(Connection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }


    public void excluirTudoProdutoZerado(ProdutoZerado p) {


        try {

            var  pstmt =  sqlConnection.createStatement();

            int linhasAfetadas = pstmt.executeUpdate("DELETE FROM tb_produto_zerado");

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    public void insertProdutoZerado(ProdutoZerado prodZ) {

    }
}
