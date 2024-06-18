package br.com.meganews.desafiojunior.desafiojunior.ui;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;

import java.math.BigDecimal;

public class Produto {

    private String Codigo;
    private String Produto;
    private String Referencia;
    private String Aplicacao;
    private String Marca;
    private String Grupo;
    private String Estoque;
    private BigDecimal Preco;
    private BigDecimal PrecoUnidade;

    public Produto(String codigo, String produto, String referencia, String aplicacao, String marca, String grupo, String estoque, BigDecimal preco, BigDecimal precoUnidade) {
        Codigo = codigo;
        Produto = produto;
        Referencia = referencia;
        Aplicacao = aplicacao;
        Marca = marca;
        Grupo = grupo;
        Estoque = estoque;
        Preco = preco;
        PrecoUnidade = precoUnidade;
    }
    public String getCodigo() {return Codigo;}
    public String getProduto() {return Produto;}
    public String getReferencia() {return Referencia;}
    public String getAplicacao() {return Aplicacao;}
    public String getMarca() {return Marca;}
    public String getGrupo() {return Grupo;}
    public String getEstoque() {return Estoque;}
    public BigDecimal getPreco() {return Preco;}
    public BigDecimal getPrecoUnidade() {return PrecoUnidade;}

    public Produto(Produtos produtos){
        Codigo = produtos.getCodigoDeBarra();
        Produto = produtos.getDescricao();
        Referencia = produtos.getReferencia();
        Aplicacao = produtos.getAplicacao();
        Marca = produtos.getIdMarca();
        Grupo = produtos.getIdGrupo();
        Estoque = produtos.getEstoqueAtual();
        Preco = new BigDecimal( produtos.getPreco());
        PrecoUnidade = new BigDecimal( produtos.getPrecoUnidade());
    }
}
