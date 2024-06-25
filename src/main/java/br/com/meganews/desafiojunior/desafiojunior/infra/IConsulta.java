package br.com.meganews.desafiojunior.desafiojunior.infra;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;

import java.util.List;

public interface IConsulta {
    List<Produtos> getProdutos();
}
