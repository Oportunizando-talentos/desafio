package br.com.meganews.desafiojunior.desafiojunior.model;

public class ProdutoZerado {
    private String codigoDeBarra;

    public ProdutoZerado() {

    }
    public ProdutoZerado(String codigoDeBarra) {

        this.codigoDeBarra = codigoDeBarra;
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }
}
