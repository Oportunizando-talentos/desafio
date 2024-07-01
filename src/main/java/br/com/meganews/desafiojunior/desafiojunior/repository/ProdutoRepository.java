package br.com.meganews.desafiojunior.desafiojunior.repository;

import br.com.meganews.desafiojunior.desafiojunior.exceptions.RemoteConnectionException;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import br.com.meganews.desafiojunior.desafiojunior.service.IProdutoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements IProdutoRepository<Produtos> {

    private static final Logger logger = LogManager.getLogger(ProdutoRepository.class);

    private final Connection sqlConnection;

    public ProdutoRepository(Connection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }


    @Override
    public List<Produtos> buscarProduto(String filtro, String filtro2, String chkGrupo){
        List<Produtos> prod = new ArrayList<>();

        String sql = "SELECT * FROM TB_PRODUTO";

        try {
            PreparedStatement db = sqlConnection.prepareStatement(sql);
            if (filtro != null) {
                db = sqlConnection.prepareStatement(sql.concat(" WHERE ESTOQUE_ATUAL = ?"));
                db.setString(1, filtro);
            }

            ResultSet resultSet = db.executeQuery();

            while (resultSet.next()) {

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
            logger.error(e.getMessage());
            throw new RemoteConnectionException();
        }

        return prod;
    }


    @Override
    public void insert(Produtos produto) {

        String sql = "INSERT INTO TB_PRODUTO (" +
                "ID_PRODUTO, CODIGO_BARRA_PRODUTO, DESCRICAO, REFERENCIA, UNIDADE, PRECO_UNIDADE, APLICACAO, DETALHE, PRECO_TABELA, PRECO, " +
                "ESTOQUE_ATUAL, FOTO_PRODUTO, DT_ULTIMA_ENTRADA_ESTOQUE, QTD_FRACIONAL, PROMOCAO, ESTOQUE_REPOSTO, PRECO_ANTERIOR, " +
                "ID_GRUPO, ID_MARCA, CST, PRECO_PF, PRECO_PJ, QUANT_EMBALAGEM, ICMS_ALIQUOTA, ICMS_BC_VALOR, ICMS_VALOR, MVA, " +
                "ICMS_ST_BC_VALOR, ICMS_ST_VALOR, MVA_PF, ICMS_ST_BC_VALOR_PF, ICMS_ST_VALOR_PF, IPI_ALIQUOTA, IPI_BC_VALOR, IPI_VALOR, " +
                "FCP, ICMS_BC_POR, ICMS_ST_BC_POR,  REDUCAO_BC, ID_CARGA, DESABILITADO" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        PreparedStatement pstmt;
        try {
            pstmt = sqlConnection.prepareStatement(sql);


            pstmt.setInt(1, (int) produto.getIdProduto());
            pstmt.setInt(2, Integer.parseInt(produto.getCodigoDeBarra()));
            pstmt.setString(3, produto.getDescricao());

            pstmt.setString(4, produto.getReferencia());
            pstmt.setString(5, produto.getUnidade());
            pstmt.setString(6, produto.getPrecoUnidade());
            pstmt.setString(7, produto.getAplicacao());
            pstmt.setString(8, produto.getDetalheProduto());
            pstmt.setString(9, produto.getTabelaPreco());
            pstmt.setString(10, produto.getPreco());
            pstmt.setInt(11, Integer.parseInt(produto.getEstoqueAtual()));
            pstmt.setString(12, produto.getFotoProduto());
            pstmt.setString(13, produto.getDataUltimaEntradaEstoque());
            pstmt.setString(14, produto.getQuantidadeFracioanl());
            pstmt.setString(15, produto.getPromocao());
            pstmt.setString(16, produto.getEstoqueReposto());
            pstmt.setString(17, produto.getPrecoAnterior());
            pstmt.setInt(18, Integer.parseInt(produto.getIdGrupo()));
            pstmt.setInt(19, Integer.parseInt(produto.getIdMarca()));
            pstmt.setString(20, produto.getCst());
            pstmt.setString(21, produto.getPrecoPF());
            pstmt.setString(22, produto.getPrecoPJ());
            pstmt.setString(23, produto.getQuantEmbalagem());
            pstmt.setString(24, produto.getIcms_aliquota());
            pstmt.setString(25, produto.getIcms_bc_valor());
            pstmt.setString(26, produto.getIcms_valor());
            pstmt.setString(27, produto.getMva());
            pstmt.setString(28, produto.getIcms_st_bc_valor());
            pstmt.setString(29, produto.getIcms_st_valor());
            pstmt.setString(30, produto.getMva_pf());
            pstmt.setString(31, produto.getIcms_st_bc_valor_pf());
            pstmt.setString(32, produto.getIcms_st_valor_pf());
            pstmt.setString(33, produto.getIpi_aliquota());
            pstmt.setString(34, produto.getIpi_bc_valor());
            pstmt.setString(35, produto.getIpi_valor());
            pstmt.setString(36, produto.getFcp());
            pstmt.setString(37, produto.getIcms_bc_por());
            pstmt.setString(38, produto.getIcms_st_bc_por());
            pstmt.setString(39, produto.getReducaoBC());
            pstmt.setInt(40, Integer.parseInt(produto.getIdCarga()));
            pstmt.setString(41, produto.getDesabilitado());

            pstmt.executeUpdate();

        } catch (SQLException exception) {
            logger.error(
                    "Não foi possível persistir o produto no banco: {}",
                    exception.getMessage()
            );
        }
    }

    @Override
    public boolean tabelaVazia() {

        String sql = "SELECT COUNT(*) AS total FROM TB_PRODUTO";
        PreparedStatement pstmt;

        try {
            pstmt = sqlConnection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            rs.next();

            return rs.getInt("total") == 0;

        } catch (SQLException e) {

            logger.error(e.getMessage());
            throw new RemoteConnectionException();

        }
    }

}
