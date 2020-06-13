package com.soluction.resources;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soluction.CategoriaServices;
import com.soluction.exception.ObjectNotFoundException;
import com.soluction.model.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	 private CategoriaServices categoriaServices;

	@RequestMapping(method = RequestMethod.GET, value = "/olamundo")
	public String olaMundo() {
		return "Olá mundo";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getcategoria")
	public ResponseEntity<?> getcategoria() {
		List<Categoria> lista = categoriaServices.getAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/find/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) {
		
		Categoria model = categoriaServices.findCategoria(id);
		if(model == null) {
			throw new ObjectNotFoundException("Objecto não encontrado");
		}
		return ResponseEntity.ok(model);
		
	}

		
	

}
