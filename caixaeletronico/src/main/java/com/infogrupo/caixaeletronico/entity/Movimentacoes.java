package com.infogrupo.caixaeletronico.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infogrupo.caixaeletronico.enums.TipoMovimentacao;

@Entity
public class Movimentacoes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer tipo;
	private Date dataMovimentacao;
	private Double valor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoMovimentacao getTipo() {
		return TipoMovimentacao.toEnum(tipo);
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo.getCod();
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Movimentacoes(Integer id, TipoMovimentacao tipo, Date dataMovimentacao,Double valor, Cliente cliente) {
		super();
		this.id = id;
		this.tipo = (tipo==null) ? null : tipo.getCod();
		this.dataMovimentacao = dataMovimentacao;
		this.valor = valor;
		this.cliente = cliente;
	}

	public Movimentacoes() {
		super();
	}

	@Override
	public String toString() {
		return "Movimentacoes [id=" + id + ", tipo=" + tipo + ", dataMovimentacao=" + dataMovimentacao + ", cliente="
				+ cliente + "]";
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
