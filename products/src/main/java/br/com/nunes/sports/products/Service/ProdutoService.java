package br.com.nunes.sports.products.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.nunes.sports.products.Entity.Produto;
import br.com.nunes.sports.products.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;


@Service
public class ProdutoService {
    
    @Autowired
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Iterable<Produto> obterTodosOsProdutos() {
        return this.produtoRepository.findAll();
    }

    public void salvarProduto(Produto produto) {
        this.produtoRepository.save(produto);
    }


 /*    @Transactional
    public void excluirProduto(Long codigo){
      this.produtoRepository.deleteByCodigo(codigo);
    //  this.produtoRepository.delete(produto);
    }*/
}
