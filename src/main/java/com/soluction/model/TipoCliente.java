package com.soluction.model;

public enum TipoCliente {
	
	PESSOA_FISICA(1, "Pessoa Física"),
	PESSOA_JURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
		
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	public static TipoCliente toPessoa(Integer key) {
		if(key == null) {
			return null;
		}
		
		for (TipoCliente tipo : TipoCliente.values()) {
			if(tipo.cod == key) {
				return tipo;
			}
		}
		 throw new IllegalArgumentException("Tipo não localizado id: "+key);
	}
	

}
