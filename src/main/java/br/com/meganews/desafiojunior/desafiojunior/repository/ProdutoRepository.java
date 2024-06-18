package br.com.meganews.desafiojunior.desafiojunior.repository;

import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements IProdutoRepository, IBuscaProdutoRepository, IProdutoEstoqueRepository {

    private Connection sqlConnection;

    public ProdutoRepository(Connection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    @Override
    public boolean ExisteProduto(String idProduto) {
        return false;
    }

    @Override
    public List buscarProduto(String filtro, String filtro2, String chkGrupo) {
        List<Produtos> prod = new ArrayList<>();

        try {
            Statement db = sqlConnection.createStatement();
            String sql = "SELECT * FROM TB_PRODUTO";
            String[] argumentos = null;
            if (filtro != null) {
                sql += " WHERE ESTOQUE_ATUAL = '" + filtro + "'";
            }

            ResultSet resultSet = db.executeQuery(sql);

            while (resultSet.next())
            {

                Produtos produto = new Produtos();
                produto.setCodigoDeBarra(resultSet.getString("CODIGO_BARRA_PRODUTO"));

                produto.setAplicacao(resultSet.getString("APLICACAO"));
                produto.setDetalheProduto(resultSet.getString("DETALHE"));
                produto.setIdProduto(resultSet.getInt("ID_PRODUTO"));
                produto.setFotoProduto(resultSet.getString("FOTO_PRODUTO"));
                produto.setCst(resultSet.getString("CST"));

                produto.setDataUltimaEntradaEstoque(resultSet.getString("DT_ULTIMA_ENTRADA_ESTOQUE"));
                produto.setDesabilitado(resultSet.getString("DESABILITADO"));
                produto.setDescGrupo(resultSet.getString("ID_GRUPO"));
                produto.setDescMarca(resultSet.getString("ID_MARCA"));
                produto.setDescricao(resultSet.getString("DESCRICAO"));
                produto.setEstoqueAtual(resultSet.getString("ESTOQUE_ATUAL"));
                produto.setEstoqueReposto(resultSet.getString("ESTOQUE_REPOSTO"));
                produto.setFcp(resultSet.getString("FCP"));
                produto.setIcms_aliquota(resultSet.getString("ICMS_ALIQUOTA"));
                produto.setIcms_bc_por(resultSet.getString("ICMS_BC_POR"));
                produto.setIcms_bc_valor(resultSet.getString("ICMS_BC_VALOR"));
                produto.setIcms_st_bc_por(resultSet.getString("ICMS_BC_POR"));
                produto.setIcms_st_bc_valor(resultSet.getString("ICMS_ST_BC_VALOR"));
                produto.setIcms_st_bc_valor_pf(resultSet.getString("ICMS_ST_BC_VALOR_PF"));
                produto.setIcms_st_valor(resultSet.getString("ICMS_ST_VALOR"));
                produto.setIcms_st_valor_pf(resultSet.getString("ICMS_ST_VALOR_PF"));
                produto.setIcms_valor(resultSet.getString("ICMS_VALOR"));
                produto.setIdCarga(resultSet.getString("ID_CARGA"));
                produto.setIdGrupo(resultSet.getString("ID_GRUPO"));
                produto.setIdMarca(resultSet.getString("ID_MARCA"));

                produto.setIpi_aliquota(resultSet.getString("IPI_ALIQUOTA"));
                produto.setIpi_bc_valor(resultSet.getString("IPI_BC_VALOR"));
                produto.setIpi_valor(resultSet.getString("IPI_VALOR"));
                produto.setMva(resultSet.getString("MVA"));
                produto.setMva_pf(resultSet.getString("MVA_PF"));
                produto.setPreco(resultSet.getString("PRECO"));
                produto.setPrecoAnterior(resultSet.getString("PRECO_ANTERIOR"));
                produto.setPrecoPF(resultSet.getString("PRECO_PF"));
                produto.setPrecoPJ(resultSet.getString("PRECO_PJ"));
                produto.setPrecoUnidade(resultSet.getString("PRECO_UNIDADE"));
                produto.setPromocao(resultSet.getString("PROMOCAO"));
                produto.setQuantEmbalagem(resultSet.getString("QUANT_EMBALAGEM"));
                produto.setQuantidadeFracioanl(resultSet.getString("QTD_FRACIONAL"));
                produto.setReducaoBC(resultSet.getString("REDUCAO_BC"));
                produto.setReferencia(resultSet.getString("REFERENCIA"));

                produto.setTabelaPreco(resultSet.getString("PRECO_TABELA"));
                produto.setUnidade(resultSet.getString("UNIDADE"));
                prod.add(produto);

            }

            resultSet.close();
            db.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return prod;
    }

    @Override
    public List buscarProdutoNaPromocao(String filtro, String filtro2, String chkGrupo) {
        return List.of();
    }

    @Override
    public List<Produtos> buscarProdutoZerado(String filtro) {

        List<Produtos> prod = new ArrayList<>();

        try {
            Statement db = sqlConnection.createStatement();
            String sql = "SELECT CODIGO_BARRA_PRODUTO, ESTOQUE_ATUAL FROM TB_PRODUTO";
            String[] argumentos = null;
            if (filtro != null) {
                sql += " WHERE ESTOQUE_ATUAL = '" + filtro + "'";
            }

            ResultSet resultSet = db.executeQuery(sql);

            while (resultSet.next())
            {

                Produtos produto = new Produtos();
                produto.setCodigoDeBarra(resultSet.getString("CODIGO_BARRA_PRODUTO"));
                prod.add(produto);

            }

            resultSet.close();
            db.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return prod;
    }

    @Override
    public String buscarPrecoVenda(String filtro, String tipoPessoa) {
        return "";
    }

    @Override
    public int atualizarEstoque(Produtos produto) {
        return 0;
    }

    @Override
    public int atualizarEstoqueReposto(Produtos produto) {
        return 0;
    }

    @Override
    public String buscarEstProduto(String filtro) {
        return "";
    }

    @Override
    public String buscarPrecoUniProduto(String filtro) {
        return "";
    }

    @Override
    public void insert(Produtos produto) {

            String sql = "INSERT INTO TB_PRODUTO (" +
                    "CODIGO_BARRA_PRODUTO, DESCRICAO, REFERENCIA, UNIDADE, PRECO_UNIDADE, APLICACAO, DETALHE, PRECO_TABELA, PRECO, " +
                    "ESTOQUE_ATUAL, FOTO_PRODUTO, DT_ULTIMA_ENTRADA_ESTOQUE, QTD_FRACIONAL, PROMOCAO, ESTOQUE_REPOSTO, PRECO_ANTERIOR, " +
                    "ID_GRUPO, ID_MARCA, CST, PRECO_PF, PRECO_PJ, QUANT_EMBALAGEM, ICMS_ALIQUOTA, ICMS_BC_VALOR, ICMS_VALOR, MVA, " +
                    "ICMS_ST_BC_VALOR, ICMS_ST_VALOR, MVA_PF, ICMS_ST_BC_VALOR_PF, ICMS_ST_VALOR_PF, IPI_ALIQUOTA, IPI_BC_VALOR, IPI_VALOR, " +
                    "FCP, ICMS_BC_POR, ICMS_ST_BC_POR,  REDUCAO_BC, ID_CARGA, DESABILITADO" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try {

                PreparedStatement pstmt = sqlConnection.prepareStatement(sql);


                pstmt.setInt(1, Integer.parseInt(produto.getCodigoDeBarra()));
                pstmt.setString(2, produto.getDescricao());

                pstmt.setString(3, produto.getReferencia());
                pstmt.setString(4, produto.getUnidade());
                pstmt.setString(5, produto.getPrecoUnidade());
                pstmt.setString(6, produto.getAplicacao());
                pstmt.setString(7, produto.getDetalheProduto());
                pstmt.setString(8,produto.getTabelaPreco());
                pstmt.setString(9,produto.getPreco());
                pstmt.setInt(10,Integer.parseInt(produto.getEstoqueAtual()));
                pstmt.setString(11,produto.getFotoProduto());
                pstmt.setString(12,produto.getDataUltimaEntradaEstoque());
                pstmt.setString(13,produto.getQuantidadeFracioanl());
                pstmt.setString(14, produto.getPromocao());
                pstmt.setString(15, produto.getEstoqueReposto());
                pstmt.setString(16, produto.getPrecoAnterior());
                pstmt.setInt(17, Integer.parseInt(produto.getIdGrupo()));
                pstmt.setInt(18, Integer.parseInt(produto.getIdMarca()));
                pstmt.setString(19, produto.getCst());
                pstmt.setString(20, produto.getPrecoPF());
                pstmt.setString(21, produto.getPrecoPJ());
                pstmt.setString(22, produto.getQuantEmbalagem());
                pstmt.setString(23,produto.getIcms_aliquota());
                pstmt.setString(24,produto.getIcms_bc_valor());
                pstmt.setString(25,produto.getIcms_valor());
                pstmt.setString(26,produto.getMva());
                pstmt.setString(27,produto.getIcms_st_bc_valor());
                pstmt.setString(28,produto.getIcms_st_valor());
                pstmt.setString(29,produto.getMva_pf());
                pstmt.setString(30,produto.getIcms_st_bc_valor_pf());
                pstmt.setString(31,produto.getIcms_st_valor_pf());
                pstmt.setString(32,produto.getIpi_aliquota());
                pstmt.setString(33,produto.getIpi_bc_valor());
                pstmt.setString(34,produto.getIpi_valor());
                pstmt.setString(35,produto.getFcp());
                pstmt.setString(36,produto.getIcms_bc_por());
                pstmt.setString(37,produto.getIcms_st_bc_por());
                pstmt.setString(38,produto.getReducaoBC());
                pstmt.setInt(39,Integer.parseInt(produto.getIdCarga()));
                pstmt.setString(40,produto.getDesabilitado());

                pstmt.executeUpdate();


              } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }

    @Override
    public int atualizar(Produtos produto) {
        return 0;
    }

    @Override
    public void salvar(Produtos produto) {

    }

    @Override
    public void excluir(Produtos produto) {

    }

    @Override
    public void excluirTudo(Produtos produto) {

    }

    @Override
    public void excluirTudoGerenciaCarga(Produtos produto) {

    }

    @Override
    public void DesabilitaProduto() {

    }
}
