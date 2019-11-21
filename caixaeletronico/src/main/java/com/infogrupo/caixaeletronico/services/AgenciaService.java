package com.infogrupo.caixaeletronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogrupo.caixaeletronico.entity.Agencia;
import com.infogrupo.caixaeletronico.repository.AgenciaRepository;

@Service
public class AgenciaService {

	@Autowired
	private AgenciaRepository agenciaRepository;
	
	public List<Agencia>buscarTodas(){
		return agenciaRepository.findAll();
	}
}
