
package br.com.meganews.desafiojunior.desafiojunior.model;



public class Produtos {

    public long idProduto;
    private String codigoDeBarra;
    private String descricao;
    private String referencia;
    private String idMarca;
    private String descMarca;
    private String unidade;
    private String precoUnidade;
    private String aplicacao;
    private String idGrupo;
    private String descGrupo;
    private String detalheProduto;
    private String tabelaPreco;
    private String preco;
    private String estoqueAtual;
    private String fotoProduto;
    private String dataUltimaEntradaEstoque;
    private String quantidadeFracioanl;
    private String promocao;
    private String precoAnterior;
    private String setQuant;
    private String estoqueReposto;
    private String quantEmbalagem;
    private String precoPF;
    private String precoPJ;
    private String cst;

    private String icms_aliquota;
    private String icms_bc_valor;
    private String icms_valor;
    private String mva;
    private String icms_st_bc_valor;
    private String icms_st_valor;
    private String mva_pf;
    private String icms_st_bc_valor_pf;
    private String icms_st_valor_pf;
    private String ipi_aliquota;
    private String ipi_bc_valor;
    private String ipi_valor;
    private String fcp;
    private String reducaoBC;
    private String icms_bc_por;
    private String icms_st_bc_por;
    private String bonificacao;
    private String idCarga = "";
    private String desabilitado = "";

    public String getDesabilitado() {
        return desabilitado;
    }

    public void setDesabilitado(String desabilitado) {
        this.desabilitado = desabilitado;
    }

    public String getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(String idCarga) {
        this.idCarga = idCarga;
    }

    private int image;

    public Produtos() {

    }
    public Produtos(long idProduto, String estoqueAtual) {

        this.idProduto = idProduto;
        this.estoqueAtual = estoqueAtual;
    }
    public Produtos(String codigoDeBarra, String estoqueReposto) {

        this.codigoDeBarra = codigoDeBarra;
        this.estoqueReposto = estoqueReposto;
    }

    public Produtos(String fotoProduto, long idProduto, String codigoDeBarra, String descricao, String descMarca, String descGrupo, String preco, String setQuant, String tabelaPreco,
                    String unidade, String precoUnidade, String estoqueAtual, String promocao, String precoAnterior, String dataUltimaEntradaEstoque, String estoqueReposto,
                    String precoPF, String precoPJ, String quantEmbalagem, String cst, String icms_aliquota, String icms_bc_valor, String icms_valor, String mva,
                    String icms_st_bc_valor, String icms_st_valor, String mva_pf, String icms_st_bc_valor_pf, String icms_st_valor_pf, String ipi_aliquota, String ipi_bc_valor,
                    String ipi_valor, String fcp, String reducaoBC, String icms_bc_por, String icms_st_bc_por, String bonificacao, String referencia) {

        this.idProduto = idProduto;
        this.codigoDeBarra = codigoDeBarra;
        this.fotoProduto = fotoProduto;
        this.descricao = descricao;
        this.descMarca = descMarca;
        this.descGrupo = descGrupo;
        this.preco = preco;
        this.setQuant = setQuant;
        this.tabelaPreco = tabelaPreco;
        this.unidade = unidade;
        this.precoUnidade = precoUnidade;
        this.estoqueAtual = estoqueAtual;
        this.promocao = promocao;
        this.precoAnterior = precoAnterior;
        this.dataUltimaEntradaEstoque = dataUltimaEntradaEstoque;
        this.estoqueReposto = estoqueReposto;
        this.precoPF = precoPF;
        this.precoPJ = precoPJ;
        this.quantEmbalagem = quantEmbalagem;
        this.cst = cst;
        this.icms_aliquota = icms_aliquota;
        this.icms_bc_valor = icms_bc_valor;
        this.icms_valor = icms_valor;
        this.mva = mva;
        this.icms_st_bc_valor = icms_st_bc_valor;
        this.icms_st_valor = icms_st_valor;
        this.mva_pf = mva_pf;
        this.icms_st_bc_valor_pf = icms_st_bc_valor_pf;
        this.icms_st_valor_pf = icms_st_valor_pf;
        this.ipi_aliquota = ipi_aliquota;
        this.ipi_bc_valor = ipi_bc_valor;
        this.ipi_valor = ipi_valor;
        this.fcp = fcp;
        this.reducaoBC = reducaoBC;
        this.icms_bc_por = icms_bc_por;
        this.icms_st_bc_por = icms_st_bc_por;
        this.bonificacao = bonificacao;
        this.referencia = referencia;
    }

    public Produtos(String descricao, int image) {

        this.descricao = descricao;
        this.image = image;
    }

    public Produtos(long idProduto, String codigoDeBarra, String descricao, String referencia, String idMarca, String unidade, String precoUnidade,
                    String aplicacao,String idGrupo, String detalheProduto, String tabelaPreco, String preco, String estoqueAtual, String fotoProduto,
                    String dataUltimaEntradaEstoque, String quantidadeFracioanl, String promocao, String precoAnterior,
                    String precoPF, String precoPJ, String quantEmbalagem, String cst, String icms_aliquota, String icms_bc_valor, String icms_valor, String mva,
                    String icms_st_bc_valor, String icms_st_valor, String mva_pf, String icms_st_bc_valor_pf, String icms_st_valor_pf, String ipi_aliquota, String ipi_bc_valor,
                    String ipi_valor, String fcp, String reducaoBC, String icms_bc_por, String icms_st_bc_por, String bonificacao, String id_carga){

        this.idProduto = idProduto;
        this.codigoDeBarra = codigoDeBarra;
        this.descricao = descricao;
        this.referencia = referencia;
        this.idMarca = idMarca;
        this.unidade = unidade;
        this.precoUnidade = precoUnidade;
        this.aplicacao = aplicacao;
        this.idGrupo = idGrupo;
        this.detalheProduto = detalheProduto;
        this.tabelaPreco = tabelaPreco;
        this.preco = preco;
        this.estoqueAtual = estoqueAtual;
        this.fotoProduto = fotoProduto;
        this.dataUltimaEntradaEstoque = dataUltimaEntradaEstoque;
        this.quantidadeFracioanl = quantidadeFracioanl;
        this.promocao = promocao;
        this.precoAnterior = precoAnterior;
        this.precoPF = precoPF;
        this.precoPJ = precoPJ;
        this.quantEmbalagem = quantEmbalagem;
        this.cst = cst;
        this.icms_aliquota = icms_aliquota;
        this.icms_bc_valor = icms_bc_valor;
        this.icms_valor = icms_valor;
        this.mva = mva;
        this.icms_st_bc_valor = icms_st_bc_valor;
        this.icms_st_valor = icms_st_valor;
        this.mva_pf = mva_pf;
        this.icms_st_bc_valor_pf = icms_st_bc_valor_pf;
        this.icms_st_valor_pf = icms_st_valor_pf;
        this.ipi_aliquota = ipi_aliquota;
        this.ipi_bc_valor = ipi_bc_valor;
        this.ipi_valor = ipi_valor;
        this.fcp = fcp;
        this.reducaoBC = reducaoBC;
        this.icms_bc_por = icms_bc_por;
        this.icms_st_bc_por = icms_st_bc_por;
        this.bonificacao = bonificacao;
        this.idCarga = id_carga;
    }

    public Produtos(long idProduto, String codigoDeBarra, String descricao, String referencia, String idMarca, String unidade, String precoUnidade,
                    String aplicacao,String idGrupo, String detalheProduto, String tabelaPreco, String preco, String estoqueAtual,
                    String dataUltimaEntradaEstoque, String quantidadeFracioanl, String promocao, String precoAnterior,
                    String precoPF, String precoPJ, String quantEmbalagem, String cst, String icms_aliquota, String icms_bc_valor, String icms_valor, String mva,
                    String icms_st_bc_valor, String icms_st_valor, String mva_pf, String icms_st_bc_valor_pf, String icms_st_valor_pf, String ipi_aliquota, String ipi_bc_valor,
                    String ipi_valor, String fcp, String reducaoBC, String icms_bc_por, String icms_st_bc_por,String id_carga, String descMarca, String descGrupo, String estoqueReposto){
        this.idProduto = idProduto;
        this.codigoDeBarra = codigoDeBarra;
        this.descricao = descricao;
        this.referencia = referencia;
        this.idMarca = idMarca;
        this.unidade = unidade;
        this.precoUnidade = precoUnidade;
        this.aplicacao = aplicacao;
        this.idGrupo = idGrupo;
        this.detalheProduto = detalheProduto;
        this.tabelaPreco = tabelaPreco;
        this.preco = preco;
        this.estoqueAtual = estoqueAtual;
        this.dataUltimaEntradaEstoque = dataUltimaEntradaEstoque;
        this.quantidadeFracioanl = quantidadeFracioanl;
        this.promocao = promocao;
        this.precoAnterior = precoAnterior;
        this.precoPF = precoPF;
        this.precoPJ = precoPJ;
        this.quantEmbalagem = quantEmbalagem;
        this.cst = cst;
        this.icms_aliquota = icms_aliquota;
        this.icms_bc_valor = icms_bc_valor;
        this.icms_valor = icms_valor;
        this.mva = mva;
        this.icms_st_bc_valor = icms_st_bc_valor;
        this.icms_st_valor = icms_st_valor;
        this.mva_pf = mva_pf;
        this.icms_st_bc_valor_pf = icms_st_bc_valor_pf;
        this.icms_st_valor_pf = icms_st_valor_pf;
        this.ipi_aliquota = ipi_aliquota;
        this.ipi_bc_valor = ipi_bc_valor;
        this.ipi_valor = ipi_valor;
        this.fcp = fcp;
        this.reducaoBC = reducaoBC;
        this.icms_bc_por = icms_bc_por;
        this.icms_st_bc_por = icms_st_bc_por;
        this.idCarga = id_carga;
        this.descMarca = descMarca;
        this.descGrupo = descGrupo;
        this.estoqueReposto = estoqueReposto;
    }


    public long getIdProduto(){
        return idProduto;
    }

    public void setIdProduto(long idProduto){
        this.idProduto = idProduto;
    }

    public String getCodigoDeBarra(){
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra){
        this.codigoDeBarra = codigoDeBarra;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getReferencia(){
        return referencia;
    }

    public void setReferencia(String referencia){
        this.referencia = referencia;
    }

    public String getIdMarca(){
        return idMarca;
    }

    public void setIdMarca(String idMarca){
        this.idMarca = idMarca;
    }

    public String getDescMarca() {
        return descMarca;
    }

    public void setDescMarca(String descMarca) {
        this.descMarca = descMarca;
    }

    public String getUnidade(){
        return unidade;
    }

    public void setUnidade(String unidade){
        this.unidade = unidade;
    }

    public String getPrecoUnidade() {
        return precoUnidade;
    }

    public void setPrecoUnidade(String precoUnidade) {
        this.precoUnidade = precoUnidade;
    }

    public String getAplicacao(){
        return aplicacao;
    }

    public void setAplicacao(String aplicacao){
        this.aplicacao = aplicacao;
    }

    public String getIdGrupo(){
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo){
        this.idGrupo = idGrupo;
    }

    public String getDescGrupo() {
        return descGrupo;
    }

    public void setDescGrupo(String descGrupo) {
        this.descGrupo = descGrupo;
    }

    public String getDetalheProduto(){
        return detalheProduto;
    }

    public void setDetalheProduto(String detalheProduto){
        this.detalheProduto = detalheProduto;
    }

    public String getTabelaPreco(){
        return tabelaPreco;
    }

    public void setTabelaPreco(String tabelaPreco){
        this.tabelaPreco = tabelaPreco;
    }

    public String getPreco(){
        return preco;
    }

    public void setPreco(String preco){
        this.preco = preco;
    }

    public String getEstoqueAtual(){
        return estoqueAtual;
    }

    public String setEstoqueAtual(String estoqueAtual){
        this.estoqueAtual = estoqueAtual;
        return estoqueAtual;
    }

    public String getFotoProduto(){
        return fotoProduto;
    }

    public void setFotoProduto(String fotoProduto){
        this.fotoProduto = fotoProduto;
    }

    public String getDataUltimaEntradaEstoque(){
        return dataUltimaEntradaEstoque;
    }

    public void setDataUltimaEntradaEstoque(String dataUltimaEntradaEstoque){
        this.dataUltimaEntradaEstoque = dataUltimaEntradaEstoque;
    }

    public String getEstoqueReposto() {
        return estoqueReposto;
    }

    public void setEstoqueReposto(String estoqueReposto) {
        this.estoqueReposto = estoqueReposto;
    }

    public String getQuantidadeFracioanl(){
        return quantidadeFracioanl;
    }

    public void setQuantidadeFracioanl(String quantidadeFracioanl){
        this.quantidadeFracioanl = quantidadeFracioanl;
    }

    public String getSetQuant(){
        return setQuant;
    }

    public void setSetQuant(String setQuant){
        this.setQuant = setQuant;
    }

    public String getPromocao(){
        return promocao;
    }

    public void setPromocao(String promocao){
        this.promocao = promocao;
    }

    public String getPrecoAnterior() {
        return precoAnterior;
    }

    public void setPrecoAnterior(String precoAnterior) {
        this.precoAnterior = precoAnterior;
    }

    public String getQuantEmbalagem() {
        return quantEmbalagem;
    }

    public void setQuantEmbalagem(String quantEmbalagem) {
        this.quantEmbalagem = quantEmbalagem;
    }

    public String getPrecoPF() {
        return precoPF;
    }

    public void setPrecoPF(String precoPF) {
        this.precoPF = precoPF;
    }

    public String getPrecoPJ() {
        return precoPJ;
    }

    public void setPrecoPJ(String precoPJ) {
        this.precoPJ = precoPJ;
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

    public String getReducaoBC() {
        return reducaoBC;
    }

    public void setReducaoBC(String reducaoBC) {
        this.reducaoBC = reducaoBC;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public String getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(String bonificacao) {
        this.bonificacao = bonificacao;
    }
}
