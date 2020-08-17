package com.soluction.CategoriaRepositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soluction.model.Product;

@Repository
public interface ProductRepositorie  extends JpaRepository<Product, Long>{

}
