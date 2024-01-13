package br.com.nunes.sports.products.Service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nunes.sports.products.Entity.Produto;
import br.com.nunes.sports.products.Repository.ProdutoRepository;
import br.com.nunes.sports.products.Service.ProdutoService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoServiceImpl implements ProdutoService{

       @Autowired
    private  ProdutoRepository produtoRepository;

    @Override
    public Iterable<Produto> getAllProduto() {
         return this.produtoRepository.findAll();
    }

    @Override
    public Produto saveProduto(Produto produto) {

        return this.produtoRepository.save(produto);
        // TODO Auto-generated method stub   
    }

    @Override
    public Produto getProdutoByCodigo(Long codigo) {

        return this.getProdutoByCodigo(codigo);
        // TODO Auto-generated method stub
    }
   
 /*  Essa lógia está correta porem quando irei editar todos os dados do cadastro somen , as vezes quero alterar só um dado 
 ai preciso preencher todos novamente , por isso deixei esse metodo em comentário
  @Override
    public Produto updateProduto(Produto produto) {
        Optional<Produto> produtoExistente = produtoRepository.findByCodigo(produto.getCodigo());
        if (produtoExistente.isPresent()) {
            Produto produtoAtualizado = produtoExistente.get();
            return produtoRepository.save(produtoAtualizado);
        } else {
          throw new EntityNotFoundException("Produto não encontrado !");

        }*/
    

    @Override
    public void deleteProdutoBycodigo(Long codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProdutoBycodigo'");
    }
} 
