package com.infogrupo.caixaeletronico.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer numeroConta;
	private Double saldo;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL, mappedBy="conta")
	private Cliente cliente;
	
	@OneToMany(mappedBy="conta", cascade=CascadeType.ALL)
	private List<Movimentacoes>movimentacoes = new ArrayList<Movimentacoes>();
	
	@OneToOne
	@JoinColumn(name="agencia_id")
	private Agencia agencia;
	
	public Conta(Integer id, Integer numeroConta, Double saldo, Agencia agencia) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.agencia = agencia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public Conta(Integer id, Integer numeroConta, Double saldo, Cliente cliente, Agencia agencia) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.cliente = cliente;
		this.agencia = agencia;
	}
	public Conta() {
		super();
	}
	@Override
	public String toString() {
		return "Conta [id=" + id + ", numeroConta=" + numeroConta + ", saldo=" + saldo + ", cliente=" + cliente
				+ ", agencia=" + agencia + "]";
	}
	public List<Movimentacoes> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(List<Movimentacoes> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	
	
	
}
