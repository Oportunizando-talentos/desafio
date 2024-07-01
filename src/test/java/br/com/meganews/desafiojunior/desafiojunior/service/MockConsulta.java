package br.com.meganews.desafiojunior.desafiojunior.service;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;

import java.util.ArrayList;
import java.util.List;

public class MockConsulta implements IConsulta {
    List<Produtos> produtos = new ArrayList<>();

    public MockConsulta(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    @Override
    public List<Produtos> getProdutos() {
        return produtos;
    }
}
