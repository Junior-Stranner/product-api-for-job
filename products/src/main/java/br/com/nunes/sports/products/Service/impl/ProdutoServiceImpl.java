package br.com.nunes.sports.products.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nunes.sports.products.Entity.Produto;
import br.com.nunes.sports.products.Repository.ProdutoRepository;
import br.com.nunes.sports.products.Service.ProdutoService;

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

//-----------------------------------------------------------------------------------------------------------------------------
   
 /* Essa lógica está correta, porém ao editar todos os dados do cadastro,
  às vezes quero alterar apenas um dado. Nesses casos, é necessário preencher todos os campos novamente.
   Por isso, deixei esse método em comentário." */
 /*  @Override
    public Produto updateProduto(Produto produto) {
        Optional<Produto> produtoExistente = produtoRepository.findByCodigo(produto.getCodigo());
        if (produtoExistente.isPresent()) {
            Produto produtoAtualizado = produtoExistente.get();
            return produtoRepository.save(produtoAtualizado);
        } else {
          throw new EntityNotFoundException("Produto não encontrado !");

        }*/
//-----------------------------------------------------------------------------------------------------------------------------


    @Override
    public void deleteProdutoBycodigo(Long codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProdutoBycodigo'");
    }
} 
