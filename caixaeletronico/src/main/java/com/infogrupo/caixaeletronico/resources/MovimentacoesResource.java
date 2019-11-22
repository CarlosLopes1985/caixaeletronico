package com.infogrupo.caixaeletronico.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.infogrupo.caixaeletronico.entity.Movimentacoes;
import com.infogrupo.caixaeletronico.entity.dto.MovimentacoesDto;
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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MovimentacoesDto objDto) {
		
		Movimentacoes obj = movimentacoesService.gravarModificacao(objDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
}
