package com.infogrupo.caixaeletronico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infogrupo.caixaeletronico.entity.Movimentacoes;
import com.infogrupo.caixaeletronico.services.MovimentacoesService;

@RestController
@RequestMapping(value="/movimentacoes")
public class MovimentacoesResource {

	@Autowired
	private MovimentacoesService movimentacoesService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Movimentacoes>> findAllContas(){
		
		List<Movimentacoes>contas = movimentacoesService.buscarTodas();
	
		return ResponseEntity.ok().body(contas);
		
	}
}
