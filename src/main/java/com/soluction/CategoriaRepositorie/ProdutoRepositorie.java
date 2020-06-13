package com.soluction.CategoriaRepositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soluction.model.Produto;

@Repository
public interface ProdutoRepositorie extends JpaRepository<Produto, Long>{

}
