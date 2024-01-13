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


    public void atualizarProduto(Produto produto) {
        // Implemente a lógica para atualizar o produto no banco de dados
        // Pode ser algo como:
        Produto produtoExistente = produtoRepository.findByCodigo(produto.getCodigo());

        if (produtoExistente != null) {
            // Atualize os atributos do produto existente com os valores do produto recebido
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setPreco(produto.getPreco());
            // Adicione outros atributos conforme necessário

            // Salve as alterações no banco de dados
            produtoRepository.save(produtoExistente);
        }
    }
}
