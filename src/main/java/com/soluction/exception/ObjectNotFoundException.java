package com.soluction.exception;

public class ObjectNotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	
	public ObjectNotFoundException() {
		super("Objecto não localizado!");
	}
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	
	public ObjectNotFoundException(Integer id ,String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable e) {
		super(msg,e);
	}

}
