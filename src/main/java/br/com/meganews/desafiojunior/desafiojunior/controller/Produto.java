package br.com.meganews.desafiojunior.desafiojunior.controller;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;

import java.math.BigDecimal;

public class Produto {

    private String Codigo;
    private String Produto;
    private String Referencia;
    private String Unidade;
    private String Marca;
    private String Grupo;
    private String Estoque;
    private BigDecimal Preco;
    private BigDecimal PrecoUnidade;
    private String Promocao;

    public Produto(String codigo, String produto, String referencia, String unidade, String marca, String grupo, String estoque, BigDecimal preco, BigDecimal precoUnidade, String promocao) {
        Codigo = codigo;
        Produto = produto;
        Referencia = referencia;
        Unidade = unidade;
        Marca = marca;
        Grupo = grupo;
        Estoque = estoque;
        Preco = preco;
        PrecoUnidade = precoUnidade;
        Promocao = promocao;
    }
    public String getCodigo() {return Codigo;}
    public String getProduto() {return Produto;}
    public String getReferencia() {return Referencia;}
    public String getUnidade() {return Unidade;}
    public String getMarca() {return Marca;}
    public String getGrupo() {return Grupo;}
    public String getEstoque() {return Estoque;}
    public BigDecimal getPreco() {return Preco;}
    public BigDecimal getPrecoUnidade() {return PrecoUnidade;}
    public String getPromocao(){return Promocao;}

    public Produto(Produtos produtos){
        Codigo = produtos.getCodigoDeBarra();
        Produto = produtos.getDescricao();
        Referencia = produtos.getReferencia();
        Unidade = produtos.getUnidade();
        Marca = produtos.getIdMarca();
        Grupo = produtos.getIdGrupo();
        Estoque = produtos.getEstoqueAtual();
        Preco = new BigDecimal( produtos.getPreco());
        PrecoUnidade = new BigDecimal( produtos.getPrecoUnidade());
        Promocao = produtos.getPromocao();
    }
}
