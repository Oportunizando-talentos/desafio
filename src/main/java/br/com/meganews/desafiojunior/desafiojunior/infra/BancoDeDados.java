package br.com.meganews.desafiojunior.desafiojunior.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MegaNews on 04/11/2015.
 */

public class BancoDeDados  {

    private Connection banco;


    public BancoDeDados(Connection connection) {
        this.banco = connection;
    }

    private final String SCRIPT_TABELA_CLIENTE = " CREATE TABLE IF NOT EXISTS TB_CLIENTE (" +
            " ID_CLIENTE INTEGER, " +
            " RAZAO_SOCIAL TEXT, " +
            " NOME_FANTASIA TEXT, " +
            " TIPO INTEGER, " +
            " CNPJCPF TEXT PRIMARY KEY, " +
            " RGIE TEXT, " +
            " DT_CADASTRO TEXT, " +
            " DT_ATUALIZACAO_CADASTRO TEXT, " +
            " ENDERECO TEXT, " +
            " PONTO_REF TEXT, " +
            " BAIRRO TEXT, " +
            " CEP TEXT, " +
            " POVOADO TEXT, " +
            " UF TEXT, " +
            " DT_ULTIMA_COMPRA TEXT, " +
            " LIMITE TEXT, " +
            " CLASSE TEXT, " +
            " NOVO_CLIENTE TEXT, " +
            " ID_USUARIO INTEGER, " +
            " STATUS_ATUALIZACAO TEXT, " +
            " ID_ROTA INTEGER, " +
            " ID_CIDADE INTEGER," +
            " DATA_NASCIMENTO TEXT," +
            " RESPONSAVEL_COMPRA TEXT, " +
            " ATIVO TEXT)";

    private final String SCRIPT_TABELA_CONTATO = "CREATE TABLE IF NOT EXISTS TB_CONTATO (" +
            " ID_CONTATO INTEGER PRIMARY KEY, " +
            " CNPJCPF TEXT, " +
            " TIPO_CONTATO INTEGER, " +
            " CONTATO TEXT, " +
            " OBS_CONTATO TEXT )";

    private final String SCRIPT_TABELA_ROTA = "CREATE TABLE IF NOT EXISTS TB_ROTA (" +
            " ID_ROTA INTEGER PRIMARY KEY, " +
            " NOME_ROTA TEXT)";

    private final String SCRIPT_TABELA_ROTA_ATENDIMENTO = "CREATE TABLE IF NOT EXISTS TB_ROTA_ATENDIMENTO (" +
            " ID_VENDEDOR INTEGER, " +
            " ID_ROTA INTEGER)";

    private final String SCRIPT_TABELA_CIDADE = "CREATE TABLE IF NOT EXISTS TB_CIDADE (" +
            " ID_CIDADE INTEGER PRIMARY KEY, " +
            " NOME_CIDADE TEXT)";

    private final String SCRIPT_TABELA_TIPOTITULO = "CREATE TABLE IF NOT EXISTS TB_TIPO_TITULO (" +
            " ID_TIPO INTEGER PRIMARY KEY, " +
            " TIPO_TITULO TEXT)";

    private final String SCRIPT_TABELA_TITULO = " CREATE TABLE IF NOT EXISTS TB_TITULO (" +
            " ID_TITULO INTEGER PRIMARY KEY, " +
            " NUMERO_TITULO TEXT, " +
            " ID_TIPO_TITULO TEXT, " +
            " VALOR_TITULO TEXT, " +
            " PARCELA_TITULO INTEGER, " +
            " DT_TITULO TEXT, " +
            " DT_VENCIMENTO_TITULO TEXT, " +
            " ID_CLIENTE INTEGER, " +
            " SITUACAO INTEGER, " +
            " DT_RECEBIMENTO TEXT )";

    private final String SCRIPT_TABELA_PEDIDO = "CREATE TABLE IF NOT EXISTS TB_PEDIDO (" +
            " ID_PEDIDO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " CNPJCPF TEXT, " +
            " ID_USUARIO INTEGER, " +
            " OBSERVACAO TEXT, " +
            " ID_PLANO_PAGAMENTO INTEGER, " +
            " ID_FORMA_PAGAMENTO INTEGER, " +
            " DT_PEDIDO TEXT," +
            " HORA_PEDIDO TEXT, " +
            " VALOR_DESCONTO TEXT, " +
            " DT_ENVIO TEXT, " +
            " HORA_ENVIO TEXT, " +
            " DT_FECHAMENTO_PEDIDO TEXT, " +
            " HORA_FECHAMENTO_PEDIDO TEXT, " +
            " STATUS INTEGER, " +
            " VALOR_TOTAL_PEDIDO TEXT, " +
            " FINALIDADE_PEDIDO TEXT, " +
            " CHECKBOX_MARCADO INTEGER, " +
            " VERSAO_APP TEXT, " +
            " STATUS_EDICAO TEXT," +
            " ID_CARGA INTEGER," +
            " TIPO_PRECO_DIFERENCIADO INTEGER)";

    private final String SCRIPT_TABELA_ITENS_PEDIDO = "CREATE TABLE IF NOT EXISTS TB_ITENS_PEDIDO (" +
            " ID_ITEM_PEDIDO INTEGER PRIMARY KEY, " +
            " ID_PEDIDO INTEGER, " +
            " ID_PRODUTO INTEGER, " +
            " VALOR_DESCONTO_ITEM TEXT, " +
            " VALOR_ACRESCIMO_ITEM TEXT, " +
            " QTD_ITEM_PEDIDO INTEGER, " +
            " PRECO_TABELA TEXT, " +
            " PRECO_VENDA TEXT, " +
            " CST TEXT, " +
            " SUBTOTAL TEXT, " +
            " ICMS_ALIQUOTA TEXT, " +
            " ICMS_BC_VALOR TEXT, " +
            " ICMS_VALOR TEXT, " +
            " MVA TEXT, " +
            " ICMS_ST_BC_VALOR TEXT, " +
            " ICMS_ST_VALOR TEXT, " +
            " MVA_PF TEXT, " +
            " ICMS_ST_BC_VALOR_PF TEXT, " +
            " ICMS_ST_VALOR_PF TEXT, " +
            " IPI_ALIQUOTA TEXT, " +
            " IPI_BC_VALOR TEXT, " +
            " IPI_VALOR TEXT, " +
            " FCP TEXT," +
            " ICMS_BC_POR TEXT," +
            " ICMS_ST_BC_POR TEXT," +
            " DESC_PLANO_POR TEXT, " +
            " DESC_PLANO_VALOR TEXT, " +
            " REDUCAO_BC TEXT, " +
            " STATUS_EXCLUSAO TEXT, " +
            " BONIFICACAO TEXT, " +
            " ID_PROMOCAO TEXT, " +
            " DESCONTO_PROMOCAO TEXT )";

    private final String SCRIPT_TABELA_PLANO_PAGAMENTO = "CREATE TABLE IF NOT EXISTS TB_PLANO_PAGAMENTO (" +
            " ID_PLANO_PAGAMENTO INTEGER PRIMARY KEY, " +
            " TIPO_PLANO INTEGER, " +
            " DESCRICAO_PLANO TEXT, " +
            " ENTRADA TEXT, " +
            " QUANT_DIAS TEXT, " +
            " PARCELA INTEGER, " +
            " TXA TEXT, " +
            " PCT_VENDA_EXTERNA TEXT, " +
            " TIPO_PCT TEXT )";


    private final String SCRIPT_TABELA_PRODUTO = " CREATE TABLE IF NOT EXISTS TB_PRODUTO (" +
            " ID_PRODUTO SERIAL PRIMARY KEY, " +
            " CODIGO_BARRA_PRODUTO INTEGER, " +
            " DESCRICAO TEXT, " +
            " REFERENCIA TEXT, " +
            " UNIDADE TEXT, " +
            " PRECO_UNIDADE TEXT, " +
            " APLICACAO TEXT, " +
            " DETALHE TEXT, " +
            " PRECO_TABELA TEXT, " +
            " PRECO TEXT, " +
            " ESTOQUE_ATUAL INTEGER, " +
            " FOTO_PRODUTO TEXT, " +
            " DT_ULTIMA_ENTRADA_ESTOQUE TEXT, " +
            " QTD_FRACIONAL TEXT, " +
            " PROMOCAO TEXT, " +
            " ESTOQUE_REPOSTO TEXT, " +
            " PRECO_ANTERIOR TEXT, " +
            " ID_GRUPO INTEGER, " +
            " ID_MARCA INTEGER, " +
            " CST TEXT, " +
            " PRECO_PF TEXT, " +
            " PRECO_PJ TEXT, " +
            " QUANT_EMBALAGEM TEXT, " +
            " ICMS_ALIQUOTA TEXT, " +
            " ICMS_BC_VALOR TEXT, " +
            " ICMS_VALOR TEXT, " +
            " MVA TEXT, " +
            " ICMS_ST_BC_VALOR TEXT, " +
            " ICMS_ST_VALOR TEXT, " +
            " MVA_PF TEXT, " +
            " ICMS_ST_BC_VALOR_PF TEXT, " +
            " ICMS_ST_VALOR_PF TEXT, " +
            " IPI_ALIQUOTA TEXT, " +
            " IPI_BC_VALOR TEXT, " +
            " IPI_VALOR TEXT, " +
            " FCP TEXT, " +
            " ICMS_BC_POR TEXT, " +
            " ICMS_ST_BC_POR TEXT, " +
            " DESC_PLANO_POR TEXT, " +
            " DESC_PLANO_VALOR TEXT, " +
            " REDUCAO_BC TEXT, " +
            " ID_CARGA INTEGER," +
            " DESABILITADO TEXT)";

    private final String SCRIPT_TABELA_MARCA = "CREATE TABLE IF NOT EXISTS TB_MARCA (" +
            " ID_MARCA INTEGER PRIMARY KEY, " +
            " DESCRICAO_MARCA TEXT)";

    private final String SCRIPT_TABELA_GRUPO = "CREATE TABLE IF NOT EXISTS TB_GRUPO (" +
            " ID_GRUPO INTEGER PRIMARY KEY, " +
            " DESCRICAO_GRUPO TEXT)";

    private final String SCRIPT_TABELA_IMAGEM = "CREATE TABLE IF NOT EXISTS TB_IMAGEM (" +
            " ID_IMAGEM INTEGER PRIMARY KEY," +
            " CODIGO_PRODUTO TEXT," +
            " FOTO BLOB)";

    private final String SCRIPT_TABELA_PROMOCAO = "CREATE TABLE IF NOT EXISTS TB_PROMOCAO (" +
            " ID_PROMOCAO INTEGER PRIMARY KEY, " +
            " NOME TEXT, " +
            " TIPO TEXT, " +
            " OBJETIVO TEXT, " +
            " TEMPO INTEGER, " +
            " DT_INICIO TEXT, " +
            " DT_VENCIMENTO TEXT, " +
            " VALOR TEXT)";

    private final String SCRIPT_TABELA_USUARIO = "CREATE TABLE IF NOT EXISTS TB_USUARIO (" +
            " ID_USUARIO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " CODIGO INTEGER, " +
            " LOGIN TEXT NOT NULL, " +
            " SENHA TEXT, " +
            " ATIVO TEXT, " +
            " MOBILE TEXT," +
            " STATUS_BLOQ_CAD_CLIENTE TEXT)";

    private final String SCRIPT_TABELA_MENSAGEM = "CREATE TABLE IF NOT EXISTS TB_MENSAGEM (" +
            " ID_MENSAGEM INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " DESCRICAO TEXT, " +
            " DATA TEXT, " +
            " HORA TEXT, " +
            " ID_USUARIO INTEGER, " +
            " STATUS_MENSAGEM INTEGER )";

    private final String SCRIPT_TABELA_ATUALIZACAO_TABELA = "CREATE TABLE IF NOT EXISTS TB_ATUALIZACAO_TABELA (" +
            " ID_ATUALIZACAO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " TABELA_ATUALIZADA TEXT, " +
            " QTD_ITENS INTEGER, " +
            " DT_ATUALIZACAO TEXT, " +
            " HORA_ATUALIZACAO TEXT)";
    private final String SCRIPT_TABELA_CONFIGURACAO = "CREATE TABLE IF NOT EXISTS TB_CONFIGURACAO (" +
            " ID_CONFIG INTEGER PRIMARY KEY, " +
            " ID_EMPRESA INTEGER, " +
            " NOME_EMPRESA TEXT, " +
            " CNPJ TEXT, " +
            " PRODUTO_ZERADO TEXT, " +
            " CORRECAO_CLIENTE INTEGER, " +
            " POR_ITEM TEXT, " +
            " DESCONTO_TOTAL TEXT, " +
            " DESCONTO_POR_ITEM TEXT, " +
            " DESCONTO_A_PRAZO TEXT, " +
            " QTD_DIAS TEXT, " +
            " QTD_TITULOS TEXT, " +
            " VALOR_MINIMO TEXT, " +
            " BLOQUEIO_CLIENTE_D TEXT, " +
            " VENDA_A_VISTA TEXT, " +
            " BLOQUEIO_ATRASO TEXT, " +
            " AUMENTAR_PRECO TEXT, " +
            " BAIXAR_PRECO TEXT, " +
            " VL_MAX_PERC TEXT, " +
            " TITULO_NAO_VENCIDO TEXT, " +
            " PARAMETRO_CONEXAO TEXT, " +
            " SENHA_ACESSO TEXT, " +
            " TIPO_SISTEMA TEXT, " +
            " BLOQUEIO_TRINTA_DIAS TEXT, " +
            " EXIBIR_META, " +
            " JUROS TEXT, " +
            " TIPO_JUROS TEXT, " +
            " CARENCIA_JUROS TEXT, " +
            " INFORMACAO_ADICIONAL TEXT, " +
            " EXIBIR_ESTOQUE TEXT, " +
            " HABILITA_CAIXA_FLEX TEXT, " +
            " HABILITA_PASTA_VENDEDOR TEXT, " +
            " VENDA_ESTOQUE_ZERADO TEXT,"+
            " VENDAFRACIONADA INTEGER," +
            " GERENCIAR_CARGA INTEGER," +
            " TIPO_PRECO_DIFERENCIADO INTEGER," +
            " ATIVAR_PRECO_DIFERENCIADO INTEGER," +
            " DESCONTO_VENDA_EXTERNA TEXT) ";


    private final String SCRIPT_TABELA_PRODUTO_ZERADO = "CREATE TABLE IF NOT EXISTS TB_PRODUTO_ZERADO (" +
            " ID_PRODUTO INTEGER)";

    private final String SCRIPT_TABELA_PLANO_CLIE = "CREATE TABLE IF NOT EXISTS TB_PLANO_CLIE (" +
            " ID INTEGER PRIMARY KEY, " +
            " ID_CLIENTE INTEGER, " +
            " ID_PLANO INTEGER)";
    private final String SCRIPT_TABELA_ESPECIE = "CREATE TABLE IF NOT EXISTS TB_ESPECIE (" +
            " ID_ESPECIE INTEGER PRIMARY KEY, " +
            " ESPECIE TEXT, " +
            " USA_MEGA_AGIL TEXT)";

    private final String SCRIPT_TABELA_ESPECIES_PLANO = "CREATE TABLE IF NOT EXISTS TB_ESPECIES_PLANO (" +
            " ID_ESPECIES_PLANO INTEGER PRIMARY KEY, " +
            " ID_ESPECIE INTEGER, " +
            " ID_PLANO INTEGER)";

    private final String SCRIPT_TABELA_PLANO_DIF_ESPECIES = "CREATE TABLE IF NOT EXISTS TB_PLANO_DIF_ESPECIES (" +
            " ID_PLANO_DIF_ESPECIES INTEGER PRIMARY KEY, " +
            " ID_PLANO_DIF INTEGER, " +
            " ID_ESPECIE INTEGER)";

    private final String SCRIPT_TABELA_RELATORIO_VENDA = "CREATE TABLE IF NOT EXISTS TB_RELATORIO_VENDA (" +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " MES TEXT, " +
            " VENDA TEXT, " +
            " QTD_PEDIDO INTEGER, " +
            " META TEXT, " +
            " F_META TEXT, " +
            " COMISSAO TEXT, " +
            " ID_VENDEDOR INTEGER )";

    private final String SCRIPT_TABELA_RELATORIO_VENDA_PLANO = "CREATE TABLE IF NOT EXISTS TB_RELATORIO_VENDA_PLANO (" +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " MES TEXT, " +
            " ID_PLANO TEXT, " +
            " VENDA TEXT, " +
            " QTD_PEDIDO INTEGER, " +
            " META TEXT, " +
            " F_META TEXT, " +
            " COMISSAO TEXT, " +
            " ID_VENDEDOR INTEGER )";

    private final String SCRIPT_TABELA_RELATORIO_VENDA_ROTA = "CREATE TABLE IF NOT EXISTS TB_RELATORIO_VENDA_ROTA (" +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " MES TEXT, " +
            " ID_ROTA TEXT, " +
            " VENDA TEXT, " +
            " QTD_PEDIDO INTEGER, " +
            " META TEXT, " +
            " F_META TEXT, " +
            " COMISSAO TEXT, " +
            " ID_VENDEDOR INTEGER )";


    private final String SCRIPT_TABELA_VISITA_SEM_VENDA = "CREATE TABLE IF NOT EXISTS TB_VISITA_SEM_VENDA (" +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " CODIGO_CLIENTE TEXT, " +
            " CNPJCPF TEXT, " +
            " RAZAO_SOCIAL TEXT, " +
            " MOTIVO TEXT, " +
            " DATA TEXT, " +
            " HORA TEXT, " +
            " INFORMACAO_ADICIONAL TEXT, " +
            " STATUS_ENVIO TEXT, " +
            " ID_VENDEDOR INTEGER )";

    private final String SCRIPT_TABELA_PROMOCOES = "CREATE TABLE IF NOT EXISTS TB_PROMOCOES (" +
            " ID_PROMOCOES INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " ATIVA TEXT, " +
            " DESCRICAO TEXT, " +
            " TIPO_REQUISITO INTEGER, " +
            " REQUISITO TEXT, " +
            " TIPO_BENEFICIO INTEGER, " +
            " BENEFICIO TEXT, " +
            " REQUISITO_MINIMO INTEGER, " +
            " VALOR_BENEFICIO TEXT )";

    private final String SCRIPT_TABELA_ITEM_PROMOCAO = "CREATE TABLE IF NOT EXISTS TB_ITEM_PROMOCAO (" +
            " ID_ITEM_PROMOCAO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " ID_PROMOCAO INTEGER, " +
            " CODIGO TEXT, " +
            " DESCRICAO TEXT, " +
            " DATA TEXT )";

    private final String SCRIPT_TABELA_CAIXA_FLEX = "CREATE TABLE IF NOT EXISTS TB_CAIXA_FLEX (" +
            " ID INTEGER PRIMARY KEY, " +
            " VALOR_CAIXA TEXT, " +
            " ID_VENDEDOR INTEGER, " +
            " DATA_INICIAL TEXT, " +
            " DATA_FINAL TEXT, " +
            " STATUS TEXT)";

    private final String SCRIPT_TABELA_CAIXA_FLEX_HISTORICO = "CREATE TABLE IF NOT EXISTS TB_CAIXA_FLEX_HISTORICO (" +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " ID_CAIXA_FLEX INTEGER, " +
            " ID_PEDIDO_FLEX INTEGER, " +
            " ID_PRODUTO_FLEX INTEGER, " +
            " CPFCNPJ TEXT, " +
            " ID_VENDEDOR INTEGER, " +
            " VALOR_CREDITO TEXT, " +
            " VALOR_DEBITO TEXT, " +
            " PRECO_TABELA TEXT, " +
            " PRECO_VENDA TEXT, " +
            " DATA TEXT, " +
            " HORA TEXT, " +
            " STATUS TEXT)";

    private final String SCRIPT_TABELA_PRECO_DIFERENCIADO = "CREATE TABLE IF NOT EXISTS TB_PRECO_DIFERENCIADO (" +
            "CODIGO_BARRA_PRODUTO TEXT PRIMARY KEY," +
            "PRIMEIRO_PRECO TEXT," +
            "SEGUNDO_PRECO TEXT)";

    private final String SCRIPT_CRIA_INDEXES_TB_PRODUTO = " CREATE INDEX TB_PRODUTO_CODIGO_BARRA_PRODUTO_IDX ON TB_PRODUTO (CODIGO_BARRA_PRODUTO); \n " +
            "CREATE INDEX TB_PRODUTO_DESCRICAO_IDX ON TB_PRODUTO (DESCRICAO);";

    public void onCreate() {
        try {
            Statement statement = banco.createStatement();
            statement.execute(SCRIPT_TABELA_PRODUTO);
            statement.execute(SCRIPT_TABELA_PRODUTO_ZERADO);

            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
