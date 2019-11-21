package com.infogrupo.caixaeletronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogrupo.caixaeletronico.entity.Conta;
import com.infogrupo.caixaeletronico.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public List<Conta>buscarTodas(){
		return contaRepository.findAll();
	}
}
