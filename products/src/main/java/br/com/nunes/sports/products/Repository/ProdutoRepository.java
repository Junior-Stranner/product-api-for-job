package br.com.nunes.sports.products.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.nunes.sports.products.Entity.Produto;

public interface ProdutoRepository extends CrudRepository <Produto, Long>{

    Produto getProdutoByCodigo(long codigo);

    void deleteByCodigo(Long codigo);

    Optional<Produto> findByCodigo(Long codigo);
    
} 

