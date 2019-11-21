package com.infogrupo.caixaeletronico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infogrupo.caixaeletronico.entity.Conta;
import com.infogrupo.caixaeletronico.services.ContaService;

@RestController
@RequestMapping(value="/contas")
public class ContaResources {

	@Autowired
	private ContaService contaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Conta>> findAllContas(){
		
		List<Conta>contas = contaService.buscarTodas();
	
		return ResponseEntity.ok().body(contas);
		
	}
}


