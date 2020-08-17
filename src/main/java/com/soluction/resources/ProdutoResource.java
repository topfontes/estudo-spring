package com.soluction.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soluction.ProductService;
import com.soluction.model.Produto;

@RestController
@RequestMapping(value="/produto")
public class ProdutoResource {
	@Autowired
	ProductService productServices;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/olamundo")
	public String olaMundo() {
		return "Olá mundo";
	}
	
	
//	@RequestMapping(value="/getAll", method = RequestMethod.GET)
//	public ResponseEntity<?> getProdutos(){
//		List<Produto> list = productServices.getAll();
//		return ResponseEntity.ok(list);
//	}
//	
//	@RequestMapping(value="/create", method = RequestMethod.POST)
//	public ResponseEntity<?> create(@RequestBody Produto produto){
//		
//		productServices.create(produto);
//		
//		return ResponseEntity.ok("Criado com sucesso");
//	}
//	
	

}
