package com.infogrupo.caixaeletronico.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer numAgencia;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL, mappedBy="agencia")
	private Conta conta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumAgencia() {
		return numAgencia;
	}

	public void setNumAgencia(Integer numAgencia) {
		this.numAgencia = numAgencia;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Agencia(Integer id, Integer numAgencia, Conta conta) {
		super();
		this.id = id;
		this.numAgencia = numAgencia;
		this.conta = conta;
	}

	public Agencia() {
		super();
	}

	@Override
	public String toString() {
		return "Agencia [id=" + id + ", numAgencia=" + numAgencia + ", conta=" + conta + "]";
	}

	public Agencia(Integer id, Integer numAgencia) {
		super();
		this.id = id;
		this.numAgencia = numAgencia;
	}
	
	
}
