package br.com.nunes.sports.products.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.nunes.sports.products.Entity.Produto;

public interface ProdutcRepository extends CrudRepository <Produto, Long>{
    
    void deleteByCodigo(Long codigo);

    List<Produto> findByCodigo(Long codigo);
    
}

