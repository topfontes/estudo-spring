package com.soluction;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soluction.CategoriaRepositorie.ClienteRepositorie;
import com.soluction.model.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepositorie clienteRepositorie;

	public Cliente findByid(Integer id) {

		Optional<Cliente> model = clienteRepositorie.findById(id);
		return model.orElse(null);

	}

}
