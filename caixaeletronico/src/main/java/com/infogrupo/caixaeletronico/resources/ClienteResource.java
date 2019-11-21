package com.infogrupo.caixaeletronico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infogrupo.caixaeletronico.entity.Cliente;
import com.infogrupo.caixaeletronico.services.ClienteService;

@RestController
@RequestMapping(value="clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAllClientes(){
		
		List<Cliente>clientes = clienteService.buscarTodas();
	
		return ResponseEntity.ok().body(clientes);
		
	}
}
