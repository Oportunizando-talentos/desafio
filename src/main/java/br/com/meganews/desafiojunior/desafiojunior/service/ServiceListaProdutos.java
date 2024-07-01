package br.com.meganews.desafiojunior.desafiojunior.service;

import br.com.meganews.desafiojunior.desafiojunior.exceptions.RemoteConnectionException;
import br.com.meganews.desafiojunior.desafiojunior.model.Produtos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ServiceListaProdutos {
    private final IProdutoRepository<Produtos> produtoRepository;
    private final IConsulta consultaAPI;
    private final Logger logger = LogManager.getLogger();

    public ServiceListaProdutos(IProdutoRepository<Produtos> produtoRepository, IConsulta consultaAPI) throws RemoteConnectionException {
        this.produtoRepository = produtoRepository;
        this.consultaAPI = consultaAPI;
        atualizar();
    }

    private void inserirProdutos() {

        consultaAPI
                .getProdutos()
                .forEach(produtoRepository::insert);

    }
    public void atualizar() {

        if (produtoRepository.tabelaVazia()) {
            inserirProdutos();
        }

    }

    public List<Produtos> listarProdutos() {

        return produtoRepository.buscarProduto(null, null, null);

    }
}
