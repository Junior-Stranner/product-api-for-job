package br.com.nunes.sports.products.Service;


import org.springframework.stereotype.Service;

import br.com.nunes.sports.products.Entity.Produto;
import br.com.nunes.sports.products.Repository.ProdutcRepository;


@Service
public class ProdutoService {
    
    private final ProdutcRepository produtoRepository;

    public ProdutoService(ProdutcRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Iterable<Produto> obterTodosOsProdutos() {
        return this.produtoRepository.findAll();
    }

    public void salvarProduto(Produto produto) {
        this.produtoRepository.save(produto);
    }

}
