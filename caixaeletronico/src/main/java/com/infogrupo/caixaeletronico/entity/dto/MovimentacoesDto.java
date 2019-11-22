package com.infogrupo.caixaeletronico.entity.dto;

import java.io.Serializable;
import java.util.Date;

public class MovimentacoesDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer tipo;
	private Date dataMovimentacao;
	private Double valor;
	private Integer idConta;

	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}
	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getIdConta() {
		return idConta;
	}
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
	public MovimentacoesDto(Integer tipo, Date dataMovimentacao, Double valor, Integer idConta) {
		super();
		this.tipo = tipo;
		this.dataMovimentacao = dataMovimentacao;
		this.valor = valor;
		this.idConta = idConta;
	}
	public MovimentacoesDto() {
		super();
	}
	
	
	
	
}
