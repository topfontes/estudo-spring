package com.soluction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soluction.CategoriaRepositorie.ProductRepositorie;
import com.soluction.model.Product;

@Service
public class ProductService {
    @Autowired
    ProductRepositorie productRepositorie;

    public List<Product> getAll() {
        List<Product> list = productRepositorie.findAll();
        return list;
    }

    public Product create(final Product produto) {
        return productRepositorie.save(produto);
    }

    public Product find(final Long id) {
        Optional<Product> prod = productRepositorie.findById(id);
        return prod.orElse(null);
    }

    public Product update(final Product product) {
        Product prod = productRepositorie.save(product);
        return prod;
    }

    public void deleteById(final Long id) {

        productRepositorie.deleteById(id);

    }

}
