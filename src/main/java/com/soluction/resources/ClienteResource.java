package com.soluction.resources;

import java.net.Authenticator.RequestorType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soluction.ClienteService;
import com.soluction.exception.ObjectNotFoundException;
import com.soluction.model.Cliente;

@RestController
@RequestMapping(value = "/clientes")		
public class ClienteResource {
	
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Cliente model = clienteService.findByid(id);
		if(model == null) {
			throw new ObjectNotFoundException("Objecto não encontrado");
		}
		return ResponseEntity.ok().body(model);
	}
	

}
