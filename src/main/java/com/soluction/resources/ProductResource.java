package com.soluction.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soluction.ProductService;
import com.soluction.model.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/olamundo")
    public String olaMundo() {
        return "Olá mundo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<?> create(@RequestBody final Product product) {

        Product prod = productService.create(product);
        return ResponseEntity.ok(prod);

    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getProducts() {
        List<Product> list = productService.getAll();
        return ResponseEntity.ok(list);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find/{id}")
    public ResponseEntity<?> find(@PathVariable final Long id) {

        Product prod = productService.find(id);
        return ResponseEntity.ok(prod);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody final Product product) {
        Product prod = productService.update(product);
        return ResponseEntity.ok(prod);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable final Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok("ok");
    }

}
