package br.com.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class Resource {

	@Autowired
	private SenderMessageMq enviarMensagem;

	@RequestMapping(method = RequestMethod.GET, value = "/sender/{value}")
	public ResponseEntity<?> sender(@PathVariable String value) throws Exception {

		enviarMensagem.send(value);

		return ResponseEntity.ok("OK");

	}

	@RequestMapping(method = RequestMethod.GET, value = "/olamundo")
	public String olaMundo() {
		return "Olá mundo";
	}
}
