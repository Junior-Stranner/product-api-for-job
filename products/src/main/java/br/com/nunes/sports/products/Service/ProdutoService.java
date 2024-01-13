package br.com.nunes.sports.products.Service;


import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.nunes.sports.products.Entity.Produto;
import br.com.nunes.sports.products.Repository.ProdutcRepository;
import jakarta.transaction.Transactional;


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


 /*    @Transactional
    public void excluirProduto(Long codigo){
      this.produtoRepository.deleteByCodigo(codigo);
    //  this.produtoRepository.delete(produto);
    }*/


   
    @Transactional
    public Produto editarProduto(Long codigo) throws Exception {
        // Busca o produto pelo código
        Optional<Produto> optionalProduto = produtoRepository.findById(codigo);

        // Verifica se o produto existe
        if (optionalProduto.isPresent()) {
            return optionalProduto.get();  // Retorna o produto para o controlador
        } else {
            // Você pode lançar uma exceção ou lidar com a situação de não encontrar o produto
            throw new Exception("Produto não encontrado para o código: " + codigo);
        }
    }
}
