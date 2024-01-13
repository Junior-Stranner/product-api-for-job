package br.com.nunes.sports.products.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.nunes.sports.products.Entity.Produto;

public interface ProdutoRepository extends CrudRepository <Produto, Long>{
    
    void deleteByCodigo(Long codigo);

    Produto findByCodigo(Long codigo);
    
} 

