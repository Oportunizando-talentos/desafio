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
            " RAZAO_SOCIAL VARCHAR(255), " +
            " NOME_FANTASIA VARCHAR(255), " +
            " TIPO INTEGER, " +
            " CNPJCPF VARCHAR(255) PRIMARY KEY, " +
            " RGIE VARCHAR(255), " +
            " DT_CADASTRO VARCHAR(255), " +
            " DT_ATUALIZACAO_CADASTRO VARCHAR(255), " +
            " ENDERECO VARCHAR(255), " +
            " PONTO_REF VARCHAR(255), " +
            " BAIRRO VARCHAR(255), " +
            " CEP VARCHAR(255), " +
            " POVOADO VARCHAR(255), " +
            " UF VARCHAR(255), " +
            " DT_ULTIMA_COMPRA VARCHAR(255), " +
            " LIMITE VARCHAR(255), " +
            " CLASSE VARCHAR(255), " +
            " NOVO_CLIENTE VARCHAR(255), " +
            " ID_USUARIO INTEGER, " +
            " STATUS_ATUALIZACAO VARCHAR(255), " +
            " ID_ROTA INTEGER, " +
            " ID_CIDADE INTEGER," +
            " DATA_NASCIMENTO VARCHAR(255)," +
            " RESPONSAVEL_COMPRA VARCHAR(255), " +
            " ATIVO VARCHAR(255))";

    private final String SCRIPT_TABELA_CONTATO = "CREATE TABLE IF NOT EXISTS TB_CONTATO (" +
            " ID_CONTATO INTEGER PRIMARY KEY, " +
            " CNPJCPF VARCHAR(255), " +
            " TIPO_CONTATO INTEGER, " +
            " CONTATO VARCHAR(255), " +
            " OBS_CONTATO VARCHAR(255) )";

    private final String SCRIPT_TABELA_ROTA = "CREATE TABLE IF NOT EXISTS TB_ROTA (" +
            " ID_ROTA INTEGER PRIMARY KEY, " +
            " NOME_ROTA VARCHAR(255))";

    private final String SCRIPT_TABELA_ROTA_ATENDIMENTO = "CREATE TABLE IF NOT EXISTS TB_ROTA_ATENDIMENTO (" +
            " ID_VENDEDOR INTEGER, " +
            " ID_ROTA INTEGER)";

    private final String SCRIPT_TABELA_CIDADE = "CREATE TABLE IF NOT EXISTS TB_CIDADE (" +
            " ID_CIDADE INTEGER PRIMARY KEY, " +
            " NOME_CIDADE VARCHAR(255))";

    private final String SCRIPT_TABELA_TIPOTITULO = "CREATE TABLE IF NOT EXISTS TB_TIPO_TITULO (" +
            " ID_TIPO INTEGER PRIMARY KEY, " +
            " TIPO_TITULO VARCHAR(255))";

    private final String SCRIPT_TABELA_TITULO = " CREATE TABLE IF NOT EXISTS TB_TITULO (" +
            " ID_TITULO INTEGER PRIMARY KEY, " +
            " NUMERO_TITULO VARCHAR(255), " +
            " ID_TIPO_TITULO VARCHAR(255), " +
            " VALOR_TITULO VARCHAR(255), " +
            " PARCELA_TITULO INTEGER, " +
            " DT_TITULO VARCHAR(255), " +
            " DT_VENCIMENTO_TITULO VARCHAR(255), " +
            " ID_CLIENTE INTEGER, " +
            " SITUACAO INTEGER, " +
            " DT_RECEBIMENTO VARCHAR(255) )";

    private final String SCRIPT_TABELA_PEDIDO = "CREATE TABLE IF NOT EXISTS TB_PEDIDO (" +
            " ID_PEDIDO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " CNPJCPF VARCHAR(255), " +
            " ID_USUARIO INTEGER, " +
            " OBSERVACAO VARCHAR(255), " +
            " ID_PLANO_PAGAMENTO INTEGER, " +
            " ID_FORMA_PAGAMENTO INTEGER, " +
            " DT_PEDIDO VARCHAR(255)," +
            " HORA_PEDIDO VARCHAR(255), " +
            " VALOR_DESCONTO VARCHAR(255), " +
            " DT_ENVIO VARCHAR(255), " +
            " HORA_ENVIO VARCHAR(255), " +
            " DT_FECHAMENTO_PEDIDO VARCHAR(255), " +
            " HORA_FECHAMENTO_PEDIDO VARCHAR(255), " +
            " STATUS INTEGER, " +
            " VALOR_TOTAL_PEDIDO VARCHAR(255), " +
            " FINALIDADE_PEDIDO VARCHAR(255), " +
            " CHECKBOX_MARCADO INTEGER, " +
            " VERSAO_APP VARCHAR(255), " +
            " STATUS_EDICAO VARCHAR(255)," +
            " ID_CARGA INTEGER," +
            " TIPO_PRECO_DIFERENCIADO INTEGER)";

    private final String SCRIPT_TABELA_ITENS_PEDIDO = "CREATE TABLE IF NOT EXISTS TB_ITENS_PEDIDO (" +
            " ID_ITEM_PEDIDO INTEGER PRIMARY KEY, " +
            " ID_PEDIDO INTEGER, " +
            " ID_PRODUTO INTEGER, " +
            " VALOR_DESCONTO_ITEM VARCHAR(255), " +
            " VALOR_ACRESCIMO_ITEM VARCHAR(255), " +
            " QTD_ITEM_PEDIDO INTEGER, " +
            " PRECO_TABELA VARCHAR(255), " +
            " PRECO_VENDA VARCHAR(255), " +
            " CST VARCHAR(255), " +
            " SUBTOTAL VARCHAR(255), " +
            " ICMS_ALIQUOTA VARCHAR(255), " +
            " ICMS_BC_VALOR VARCHAR(255), " +
            " ICMS_VALOR VARCHAR(255), " +
            " MVA VARCHAR(255), " +
            " ICMS_ST_BC_VALOR VARCHAR(255), " +
            " ICMS_ST_VALOR VARCHAR(255), " +
            " MVA_PF VARCHAR(255), " +
            " ICMS_ST_BC_VALOR_PF VARCHAR(255), " +
            " ICMS_ST_VALOR_PF VARCHAR(255), " +
            " IPI_ALIQUOTA VARCHAR(255), " +
            " IPI_BC_VALOR VARCHAR(255), " +
            " IPI_VALOR VARCHAR(255), " +
            " FCP VARCHAR(255)," +
            " ICMS_BC_POR VARCHAR(255)," +
            " ICMS_ST_BC_POR VARCHAR(255)," +
            " DESC_PLANO_POR VARCHAR(255), " +
            " DESC_PLANO_VALOR VARCHAR(255), " +
            " REDUCAO_BC VARCHAR(255), " +
            " STATUS_EXCLUSAO VARCHAR(255), " +
            " BONIFICACAO VARCHAR(255), " +
            " ID_PROMOCAO VARCHAR(255), " +
            " DESCONTO_PROMOCAO VARCHAR(255) )";

    private final String SCRIPT_TABELA_PLANO_PAGAMENTO = "CREATE TABLE IF NOT EXISTS TB_PLANO_PAGAMENTO (" +
            " ID_PLANO_PAGAMENTO INTEGER PRIMARY KEY, " +
            " TIPO_PLANO INTEGER, " +
            " DESCRICAO_PLANO VARCHAR(255), " +
            " ENTRADA VARCHAR(255), " +
            " QUANT_DIAS VARCHAR(255), " +
            " PARCELA INTEGER, " +
            " TXA VARCHAR(255), " +
            " PCT_VENDA_EXTERNA VARCHAR(255), " +
            " TIPO_PCT VARCHAR(255) )";


    private final String SCRIPT_TABELA_PRODUTO = " CREATE TABLE IF NOT EXISTS TB_PRODUTO (" +
            " ID_PRODUTO INTEGER PRIMARY KEY, " +
            " CODIGO_BARRA_PRODUTO INTEGER, " +
            " DESCRICAO VARCHAR(255), " +
            " REFERENCIA VARCHAR(255), " +
            " UNIDADE VARCHAR(255), " +
            " PRECO_UNIDADE VARCHAR(255), " +
            " APLICACAO VARCHAR(255), " +
            " DETALHE VARCHAR(255), " +
            " PRECO_TABELA VARCHAR(255), " +
            " PRECO VARCHAR(255), " +
            " ESTOQUE_ATUAL INTEGER, " +
            " FOTO_PRODUTO VARCHAR(255), " +
            " DT_ULTIMA_ENTRADA_ESTOQUE VARCHAR(255), " +
            " QTD_FRACIONAL VARCHAR(255), " +
            " PROMOCAO VARCHAR(255), " +
            " ESTOQUE_REPOSTO VARCHAR(255), " +
            " PRECO_ANTERIOR VARCHAR(255), " +
            " ID_GRUPO INTEGER, " +
            " ID_MARCA INTEGER, " +
            " CST VARCHAR(255), " +
            " PRECO_PF VARCHAR(255), " +
            " PRECO_PJ VARCHAR(255), " +
            " QUANT_EMBALAGEM VARCHAR(255), " +
            " ICMS_ALIQUOTA VARCHAR(255), " +
            " ICMS_BC_VALOR VARCHAR(255), " +
            " ICMS_VALOR VARCHAR(255), " +
            " MVA VARCHAR(255), " +
            " ICMS_ST_BC_VALOR VARCHAR(255), " +
            " ICMS_ST_VALOR VARCHAR(255), " +
            " MVA_PF VARCHAR(255), " +
            " ICMS_ST_BC_VALOR_PF VARCHAR(255), " +
            " ICMS_ST_VALOR_PF VARCHAR(255), " +
            " IPI_ALIQUOTA VARCHAR(255), " +
            " IPI_BC_VALOR VARCHAR(255), " +
            " IPI_VALOR VARCHAR(255), " +
            " FCP VARCHAR(255), " +
            " ICMS_BC_POR VARCHAR(255), " +
            " ICMS_ST_BC_POR VARCHAR(255), " +
            " DESC_PLANO_POR VARCHAR(255), " +
            " DESC_PLANO_VALOR VARCHAR(255), " +
            " REDUCAO_BC VARCHAR(255), " +
            " ID_CARGA INTEGER," +
            " DESABILITADO VARCHAR(255))";

    private final String SCRIPT_TABELA_MARCA = "CREATE TABLE IF NOT EXISTS TB_MARCA (" +
            " ID_MARCA INTEGER PRIMARY KEY, " +
            " DESCRICAO_MARCA VARCHAR(255))";

    private final String SCRIPT_TABELA_GRUPO = "CREATE TABLE IF NOT EXISTS TB_GRUPO (" +
            " ID_GRUPO INTEGER PRIMARY KEY, " +
            " DESCRICAO_GRUPO VARCHAR(255))";

    private final String SCRIPT_TABELA_IMAGEM = "CREATE TABLE IF NOT EXISTS TB_IMAGEM (" +
            " ID_IMAGEM INTEGER PRIMARY KEY," +
            " CODIGO_PRODUTO VARCHAR(255)," +
            " FOTO BLOB)";

    private final String SCRIPT_TABELA_PROMOCAO = "CREATE TABLE IF NOT EXISTS TB_PROMOCAO (" +
            " ID_PROMOCAO INTEGER PRIMARY KEY, " +
            " NOME VARCHAR(255), " +
            " TIPO VARCHAR(255), " +
            " OBJETIVO VARCHAR(255), " +
            " TEMPO INTEGER, " +
            " DT_INICIO VARCHAR(255), " +
            " DT_VENCIMENTO VARCHAR(255), " +
            " VALOR VARCHAR(255))";

    private final String SCRIPT_TABELA_USUARIO = "CREATE TABLE IF NOT EXISTS TB_USUARIO (" +
            " ID_USUARIO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " CODIGO INTEGER, " +
            " LOGIN VARCHAR(255) NOT NULL, " +
            " SENHA VARCHAR(255), " +
            " ATIVO VARCHAR(255), " +
            " MOBILE VARCHAR(255)," +
            " STATUS_BLOQ_CAD_CLIENTE VARCHAR(255))";

    private final String SCRIPT_TABELA_MENSAGEM = "CREATE TABLE IF NOT EXISTS TB_MENSAGEM (" +
            " ID_MENSAGEM INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " DESCRICAO VARCHAR(255), " +
            " DATA VARCHAR(255), " +
            " HORA VARCHAR(255), " +
            " ID_USUARIO INTEGER, " +
            " STATUS_MENSAGEM INTEGER )";

    private final String SCRIPT_TABELA_ATUALIZACAO_TABELA = "CREATE TABLE IF NOT EXISTS TB_ATUALIZACAO_TABELA (" +
            " ID_ATUALIZACAO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " TABELA_ATUALIZADA VARCHAR(255), " +
            " QTD_ITENS INTEGER, " +
            " DT_ATUALIZACAO VARCHAR(255), " +
            " HORA_ATUALIZACAO VARCHAR(255))";

    private final String SCRIPT_TABELA_CONFIGURACAO = "CREATE TABLE IF NOT EXISTS TB_CONFIGURACAO (" +
            " ID_CONFIG INTEGER PRIMARY KEY, " +
            " ID_EMPRESA INTEGER, " +
            " NOME_EMPRESA VARCHAR(255), " +
            " CNPJ VARCHAR(255), " +
            " PRODUTO_ZERADO VARCHAR(255), " +
            " CORRECAO_CLIENTE INTEGER, " +
            " POR_ITEM VARCHAR(255), " +
            " DESCONTO_TOTAL VARCHAR(255), " +
            " DESCONTO_POR_ITEM VARCHAR(255), " +
            " DESCONTO_A_PRAZO VARCHAR(255), " +
            " QTD_DIAS VARCHAR(255), " +
            " QTD_TITULOS VARCHAR(255), " +
            " VALOR_MINIMO VARCHAR(255), " +
            " BLOQUEIO_CLIENTE_D VARCHAR(255), " +
            " VENDA_A_VISTA VARCHAR(255), " +
            " BLOQUEIO_ATRASO VARCHAR(255), " +
            " AUMENTAR_PRECO VARCHAR(255), " +
            " BAIXAR_PRECO VARCHAR(255), " +
            " VL_MAX_PERC VARCHAR(255), " +
            " TITULO_NAO_VENCIDO VARCHAR(255), " +
            " PARAMETRO_CONEXAO VARCHAR(255), " +
            " SENHA_ACESSO VARCHAR(255), " +
            " TIPO_SISTEMA VARCHAR(255), " +
            " BLOQUEIO_TRINTA_DIAS VARCHAR(255), " +
            " EXIBIR_META, " +
            " JUROS VARCHAR(255), " +
            " TIPO_JUROS VARCHAR(255), " +
            " CARENCIA_JUROS VARCHAR(255), " +
            " INFORMACAO_ADICIONAL VARCHAR(255), " +
            " EXIBIR_ESTOQUE VARCHAR(255), " +
            " HABILITA_CAIXA_FLEX VARCHAR(255), " +
            " HABILITA_PASTA_VENDEDOR VARCHAR(255), " +
            " VENDA_ESTOQUE_ZERADO VARCHAR(255),"+
            " VENDAFRACIONADA INTEGER," +
            " GERENCIAR_CARGA INTEGER," +
            " TIPO_PRECO_DIFERENCIADO INTEGER," +
            " ATIVAR_PRECO_DIFERENCIADO INTEGER," +
            " DESCONTO_VENDA_EXTERNA VARCHAR(255)) ";


    private final String SCRIPT_TABELA_PRODUTO_ZERADO = "CREATE TABLE IF NOT EXISTS TB_PRODUTO_ZERADO (" +
            " ID_PRODUTO INTEGER)";

    private final String SCRIPT_TABELA_PLANO_CLIE = "CREATE TABLE IF NOT EXISTS TB_PLANO_CLIE (" +
            " ID INTEGER PRIMARY KEY, " +
            " ID_CLIENTE INTEGER, " +
            " ID_PLANO INTEGER)";
    private final String SCRIPT_TABELA_ESPECIE = "CREATE TABLE IF NOT EXISTS TB_ESPECIE (" +
            " ID_ESPECIE INTEGER PRIMARY KEY, " +
            " ESPECIE VARCHAR(255), " +
            " USA_MEGA_AGIL VARCHAR(255))";

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
            " MES VARCHAR(255), " +
            " VENDA VARCHAR(255), " +
            " QTD_PEDIDO INTEGER, " +
            " META VARCHAR(255), " +
            " F_META VARCHAR(255), " +
            " COMISSAO VARCHAR(255), " +
            " ID_VENDEDOR INTEGER )";

    private final String SCRIPT_TABELA_RELATORIO_VENDA_PLANO = "CREATE TABLE IF NOT EXISTS TB_RELATORIO_VENDA_PLANO (" +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " MES VARCHAR(255), " +
            " ID_PLANO VARCHAR(255), " +
            " VENDA VARCHAR(255), " +
            " QTD_PEDIDO INTEGER, " +
            " META VARCHAR(255), " +
            " F_META VARCHAR(255), " +
            " COMISSAO VARCHAR(255), " +
            " ID_VENDEDOR INTEGER )";

    private final String SCRIPT_TABELA_RELATORIO_VENDA_ROTA = "CREATE TABLE IF NOT EXISTS TB_RELATORIO_VENDA_ROTA (" +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " MES VARCHAR(255), " +
            " ID_ROTA VARCHAR(255), " +
            " VENDA VARCHAR(255), " +
            " QTD_PEDIDO INTEGER, " +
            " META VARCHAR(255), " +
            " F_META VARCHAR(255), " +
            " COMISSAO VARCHAR(255), " +
            " ID_VENDEDOR INTEGER )";


    private final String SCRIPT_TABELA_VISITA_SEM_VENDA = "CREATE TABLE IF NOT EXISTS TB_VISITA_SEM_VENDA (" +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " CODIGO_CLIENTE VARCHAR(255), " +
            " CNPJCPF VARCHAR(255), " +
            " RAZAO_SOCIAL VARCHAR(255), " +
            " MOTIVO VARCHAR(255), " +
            " DATA VARCHAR(255), " +
            " HORA VARCHAR(255), " +
            " INFORMACAO_ADICIONAL VARCHAR(255), " +
            " STATUS_ENVIO VARCHAR(255), " +
            " ID_VENDEDOR INTEGER )";

    private final String SCRIPT_TABELA_PROMOCOES = "CREATE TABLE IF NOT EXISTS TB_PROMOCOES (" +
            " ID_PROMOCOES INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " ATIVA VARCHAR(255), " +
            " DESCRICAO VARCHAR(255), " +
            " TIPO_REQUISITO INTEGER, " +
            " REQUISITO VARCHAR(255), " +
            " TIPO_BENEFICIO INTEGER, " +
            " BENEFICIO VARCHAR(255), " +
            " REQUISITO_MINIMO INTEGER, " +
            " VALOR_BENEFICIO VARCHAR(255) )";

    private final String SCRIPT_TABELA_ITEM_PROMOCAO = "CREATE TABLE IF NOT EXISTS TB_ITEM_PROMOCAO (" +
            " ID_ITEM_PROMOCAO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " ID_PROMOCAO INTEGER, " +
            " CODIGO VARCHAR(255), " +
            " DESCRICAO VARCHAR(255), " +
            " DATA VARCHAR(255) )";

    private final String SCRIPT_TABELA_CAIXA_FLEX = "CREATE TABLE IF NOT EXISTS TB_CAIXA_FLEX (" +
            " ID INTEGER PRIMARY KEY, " +
            " VALOR_CAIXA VARCHAR(255), " +
            " ID_VENDEDOR INTEGER, " +
            " DATA_INICIAL VARCHAR(255), " +
            " DATA_FINAL VARCHAR(255), " +
            " STATUS VARCHAR(255))";

    private final String SCRIPT_TABELA_CAIXA_FLEX_HISTORICO = "CREATE TABLE IF NOT EXISTS TB_CAIXA_FLEX_HISTORICO (" +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " ID_CAIXA_FLEX INTEGER, " +
            " ID_PEDIDO_FLEX INTEGER, " +
            " ID_PRODUTO_FLEX INTEGER, " +
            " CPFCNPJ VARCHAR(255), " +
            " ID_VENDEDOR INTEGER, " +
            " VALOR_CREDITO VARCHAR(255), " +
            " VALOR_DEBITO VARCHAR(255), " +
            " PRECO_TABELA VARCHAR(255), " +
            " PRECO_VENDA VARCHAR(255), " +
            " DATA VARCHAR(255), " +
            " HORA VARCHAR(255), " +
            " STATUS VARCHAR(255))";

    private final String SCRIPT_TABELA_PRECO_DIFERENCIADO = "CREATE TABLE IF NOT EXISTS TB_PRECO_DIFERENCIADO (" +
            "CODIGO_BARRA_PRODUTO VARCHAR(255) PRIMARY KEY," +
            "PRIMEIRO_PRECO VARCHAR(255)," +
            "SEGUNDO_PRECO VARCHAR(255))";

    private final String SCRIPT_CRIA_INDEXES_TB_PRODUTO = " CREATE INDEX TB_PRODUTO_CODIGO_BARRA_PRODUTO_IDX ON TB_PRODUTO (CODIGO_BARRA_PRODUTO); \n " +
            "CREATE INDEX TB_PRODUTO_DESCRICAO_IDX ON TB_PRODUTO (DESCRICAO);";

    public void onCreate() {
        try {
            Statement statement = banco.createStatement();
            boolean execute = statement.execute(SCRIPT_TABELA_PRODUTO);
//            statement.execute(SCRIPT_TABELA_PRODUTO_ZERADO);

            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
