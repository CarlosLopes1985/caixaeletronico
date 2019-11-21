package com.infogrupo.caixaeletronico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogrupo.caixaeletronico.repository.MovimentacoesRepository;

@Service
public class MovimentacoesService {
	
	@Autowired
	private MovimentacoesRepository movimentacoesRepository;
	
}
