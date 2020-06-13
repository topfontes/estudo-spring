package com.soluction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soluction.CategoriaRepositorie.CategoriaRepositorie;
import com.soluction.model.Categoria;

@Service
public class CategoriaServices {
	
	@Autowired
	private CategoriaRepositorie categoriareposiyory;
	
	public Categoria findCategoria(Long id) {
		Optional<Categoria> model = categoriareposiyory.findById(id);
		return model.orElse(null);
		
	}
	
	public List<Categoria> getAll(){
		List<Categoria> list = categoriareposiyory.findAll();
		return list;
	}

}
