package br.com.nunes.sports.products.Service;

import java.util.List;

import br.com.nunes.sports.products.Entity.Produto;

public interface ProdutoService {


    Iterable<Produto> getAllProduto();
	
	Produto saveProduto(Produto produto);
	
	Produto getProdutoByCodigo(Long codigo);
	
//	Produto updateProduto(Produto produto);
	
	void deleteProdutoBycodigo(Long codigo);

}
