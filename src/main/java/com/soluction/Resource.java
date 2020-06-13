package com.soluction;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/")
public class Resource {
	
	@RequestMapping(method = RequestMethod.GET, value = "/send")
	public String send() {
		
		return "OK!";
		
	}
	@RequestMapping(method = RequestMethod.GET, value = "/olamundo")
	public String olaMundo() {
		return "Olá mundo";
	}
}
