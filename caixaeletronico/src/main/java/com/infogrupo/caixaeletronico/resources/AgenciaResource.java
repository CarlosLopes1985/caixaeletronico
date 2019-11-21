package com.infogrupo.caixaeletronico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infogrupo.caixaeletronico.entity.Agencia;
import com.infogrupo.caixaeletronico.services.AgenciaService;

@RestController
@RequestMapping(value="/agencias")
public class AgenciaResource {
	
	@Autowired
	private AgenciaService agenciaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Agencia>> findAllAgencias(){
		
		List<Agencia>agencias = agenciaService.buscarTodas();
	
		return ResponseEntity.ok().body(agencias);
		
	}
}
