package com.infogrupo.caixaeletronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogrupo.caixaeletronico.entity.Cliente;
import com.infogrupo.caixaeletronico.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente>buscarTodas(){
		return clienteRepository.findAll();
	}
}
