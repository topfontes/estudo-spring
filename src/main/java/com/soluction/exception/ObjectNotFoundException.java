package com.soluction.exception;

public class ObjectNotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	
	public ObjectNotFoundException() {
		super("Objecto não localizado!");
	}
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(Integer idpk ,String msg, Object obj) {
		
		StringBuffer sb = new StringBuffer().append(msg).append(" id: ").append(idpk).append(" ").append(obj.getClass());
		
	}
	
	public ObjectNotFoundException(Integer id ,String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable e) {
		super(msg,e);
	}

}
