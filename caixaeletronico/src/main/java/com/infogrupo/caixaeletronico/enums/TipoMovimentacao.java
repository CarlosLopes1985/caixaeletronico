package com.infogrupo.caixaeletronico.enums;

public enum TipoMovimentacao {
	
	DEPOSITO(1,"Depósito"),
	RETIRADA(2,"Retirada"),
	TRANSFERENCIA(3,"Transferencia");
	
	private int cod;
	private String descricao;
	
	private TipoMovimentacao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoMovimentacao toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoMovimentacao x : TipoMovimentacao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
	
}
