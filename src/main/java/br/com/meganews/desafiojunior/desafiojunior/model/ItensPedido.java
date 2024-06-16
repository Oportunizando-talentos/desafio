package br.com.meganews.desafiojunior.desafiojunior.model;



import br.com.meganews.desafiojunior.desafiojunior.util.ArredondaPreco;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by MegaNews on 27/11/2015.
 */
public class ItensPedido implements Serializable {

    public long idItemPedido;
    private long idProduto;
    private String codigoBarra;
    private long idPedido;
    private String descricao;
    private double valorDesconto;
    private BigDecimal valorAcrescimo;
    private String quantidade;
    private double precoVenda;
    private String tabelaPreco;
    private BigDecimal precoUnidade;
    private BigDecimal precoTabela;
    private String estoqueAtual;
    private double subTotalItem;
    private String quantEmbalagem;
    private String cst;
    private String icms_aliquota;
    private String icms_bc_valor;
    private String icms_bc_por;
    private String icms_valor;
    private String mva;
    private String icms_st_bc_valor;
    private String icms_st_valor;
    private String icms_st_bc_por;
    private String mva_pf;
    private String icms_st_bc_valor_pf;
    private String icms_st_valor_pf;
    private String ipi_aliquota;
    private String ipi_bc_valor;
    private String ipi_valor;
    private String fcp;
    private String descPlanoPor;
    private double descPlanoValor;
    private String reducaoBC;
    private String statusExclusao;
    private String bonificacao;
    private String idPromocao;
    private double descontoPromocao;
    private String data;//somente para exibir a data da compra do item na venda;


    public ItensPedido()
    {

    }
    public ItensPedido(long idItemPedido)
    {
        this.idItemPedido = idItemPedido;
    }

    public ItensPedido(long idPedido, long idProduto, String statusExclusao){
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.statusExclusao = statusExclusao;
    }

    public ItensPedido(long idItemPedido, long idPedido, long idProduto, String codigoBarra, String descricao, String quantidade,
                       double precoVenda, String tabelaPreco, double valorDesconto, BigDecimal precoUnidade, String estoqueAtual, double subTotalItem,
                       String quantEmbalagem, String cst, String icms_aliquota, String icms_bc_valor, String icms_bc_por, String icms_st_bc_por,
                       String icms_valor, String mva, String icms_st_bc_valor, String icms_st_valor, String mva_pf, String icms_st_bc_valor_pf,
                       String icms_st_valor_pf, String ipi_aliquota, String ipi_bc_valor, String ipi_valor, String fcp, String descPlanoPor,
                       double descPlanoValor, String reducaoBC, String bonificacao, String idPromocao, double descontoPromocao )
    {
        this.idItemPedido = idItemPedido;
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.codigoBarra = codigoBarra;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
        this.tabelaPreco = tabelaPreco;
        this.valorDesconto = valorDesconto;
        this.precoUnidade = precoUnidade;
        this.estoqueAtual = estoqueAtual;
        this.subTotalItem = subTotalItem;
        this.quantEmbalagem = quantEmbalagem;
        this.cst = cst;
        this.icms_aliquota = icms_aliquota;
        this.icms_bc_valor = icms_bc_valor;
        this.icms_bc_por = icms_bc_por;
        this.icms_valor = icms_valor;
        this.mva = mva;
        this.icms_st_bc_valor = icms_st_bc_valor;
        this.icms_st_valor = icms_st_valor;
        this.icms_st_bc_por = icms_st_bc_por;
        this.mva_pf = mva_pf;
        this.icms_st_bc_valor_pf = icms_st_bc_valor_pf;
        this.icms_st_valor_pf = icms_st_valor_pf;
        this.ipi_aliquota = ipi_aliquota;
        this.ipi_bc_valor = ipi_bc_valor;
        this.ipi_valor = ipi_valor;
        this.fcp = fcp;
        this.descPlanoPor = descPlanoPor;
        this.descPlanoValor = descPlanoValor;
        this.reducaoBC = reducaoBC;
        this.bonificacao = bonificacao;
        this.idPromocao = idPromocao;
        this.descontoPromocao = descontoPromocao;
    }

    public double getPercentualDesconto() {
        return ArredondaPreco.Arredonda((valorDesconto / Double.parseDouble(tabelaPreco)) * 100, 2);
    }

    public long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(BigDecimal valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoTabela() {
        return precoTabela;
    }

    public void setPrecoTabela(BigDecimal precoTabela) {
        this.precoTabela = precoTabela;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getIcms_bc_por() {
        return icms_bc_por;
    }

    public void setIcms_bc_por(String icms_bc_por) {
        this.icms_bc_por = icms_bc_por;
    }

    public String getIcms_st_bc_por() {
        return icms_st_bc_por;
    }

    public void setIcms_st_bc_por(String icms_st_bc_por) {
        this.icms_st_bc_por = icms_st_bc_por;
    }

    public String getTabelaPreco() {
        return tabelaPreco;
    }

    public double getTabelaPrecoValor() { return new BigDecimal(tabelaPreco).doubleValue(); }

    public void setTabelaPreco(String tabelaPreco) {
        this.tabelaPreco = tabelaPreco;
    }

    public BigDecimal getPrecoUnidade() {
        return precoUnidade;
    }

    public void setPrecoUnidade(BigDecimal precoUnidade) {
        this.precoUnidade = precoUnidade;
    }

    public String getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(String estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public double getSubTotalItem() {
        return subTotalItem;
    }

    public void setSubTotalItem(double subTotalItem) {
        this.subTotalItem = subTotalItem;
    }

    public String getQuantEmbalagem() {
        return quantEmbalagem;
    }

    public void setQuantEmbalagem(String quantEmbalagem) {
        this.quantEmbalagem = quantEmbalagem;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getIcms_aliquota() {
        return icms_aliquota;
    }

    public void setIcms_aliquota(String icms_aliquota) {
        this.icms_aliquota = icms_aliquota;
    }

    public String getIcms_bc_valor() {
        return icms_bc_valor;
    }

    public void setIcms_bc_valor(String icms_bc_valor) {
        this.icms_bc_valor = icms_bc_valor;
    }

    public String getIcms_valor() {
        return icms_valor;
    }

    public void setIcms_valor(String icms_valor) {
        this.icms_valor = icms_valor;
    }

    public String getMva() {
        return mva;
    }

    public void setMva(String mva) {
        this.mva = mva;
    }

    public String getIcms_st_bc_valor() {
        return icms_st_bc_valor;
    }

    public void setIcms_st_bc_valor(String icms_st_bc_valor) {
        this.icms_st_bc_valor = icms_st_bc_valor;
    }

    public String getIcms_st_valor() {
        return icms_st_valor;
    }

    public void setIcms_st_valor(String icms_st_valor) {
        this.icms_st_valor = icms_st_valor;
    }

    public String getMva_pf() {
        return mva_pf;
    }

    public void setMva_pf(String mva_pf) {
        this.mva_pf = mva_pf;
    }

    public String getIcms_st_bc_valor_pf() {
        return icms_st_bc_valor_pf;
    }

    public void setIcms_st_bc_valor_pf(String icms_st_bc_valor_pf) {
        this.icms_st_bc_valor_pf = icms_st_bc_valor_pf;
    }

    public String getIcms_st_valor_pf() {
        return icms_st_valor_pf;
    }

    public void setIcms_st_valor_pf(String icms_st_valor_pf) {
        this.icms_st_valor_pf = icms_st_valor_pf;
    }

    public String getIpi_aliquota() {
        return ipi_aliquota;
    }

    public void setIpi_aliquota(String ipi_aliquota) {
        this.ipi_aliquota = ipi_aliquota;
    }

    public String getIpi_bc_valor() {
        return ipi_bc_valor;
    }

    public void setIpi_bc_valor(String ipi_bc_valor) {
        this.ipi_bc_valor = ipi_bc_valor;
    }

    public String getIpi_valor() {
        return ipi_valor;
    }

    public void setIpi_valor(String ipi_valor) {
        this.ipi_valor = ipi_valor;
    }

    public String getFcp() {
        return fcp;
    }

    public void setFcp(String fcp) {
        this.fcp = fcp;
    }

    public String getDescPlanoPor() {
        return descPlanoPor;
    }

    public void setDescPlanoPor(String descPlanoPor) {
        this.descPlanoPor = descPlanoPor;
    }

    public double getDescPlanoValor() {
        return descPlanoValor;
    }

    public void setDescPlanoValor(double descPlanoValor) {
        this.descPlanoValor = descPlanoValor;
    }

    public String getReducaoBC() {
        return reducaoBC;
    }

    public void setReducaoBC(String reducaoBC) {
        this.reducaoBC = reducaoBC;
    }

    public String getStatusExclusao() {
        return statusExclusao;
    }

    public void setStatusExclusao(String statusExclusao) {
        this.statusExclusao = statusExclusao;
    }

    public String getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(String bonificacao) {
        this.bonificacao = bonificacao;
    }

    public String getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(String idPromocao) {
        this.idPromocao = idPromocao;
    }

    public double getDescontoPromocao() {
        return descontoPromocao;
    }

    public void setDescontoPromocao(double descontoPromocao) {
        this.descontoPromocao = descontoPromocao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getTotalDesconto() {
        return valorDesconto * Double.parseDouble(quantidade);
    }
    public double getTotalBruto() {
        return Double.parseDouble(quantidade) * (valorDesconto + precoVenda);
    }
}
