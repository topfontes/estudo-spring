package com.soluction.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soluction.model.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET, value = "/olamundo")
	public String olaMundo() {
		return "Olá mundo";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getcategoria")
	public List<Categoria> getcategoria() {
		
		List<Categoria> lista = new ArrayList<Categoria>();
		lista.add(new Categoria(1,"Informatica"));
		lista.add(new Categoria(2,"Escritório"));
		return lista;
		
	}
		
	

}
