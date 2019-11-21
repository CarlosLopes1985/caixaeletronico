package com.infogrupo.caixaeletronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogrupo.caixaeletronico.entity.Conta;
import com.infogrupo.caixaeletronico.entity.Movimentacoes;
import com.infogrupo.caixaeletronico.repository.ContaRepository;
import com.infogrupo.caixaeletronico.repository.MovimentacoesRepository;

@Service
public class MovimentacoesService {
	
	@Autowired
	private MovimentacoesRepository movimentacoesRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	public List<Movimentacoes>buscarTodas(){
		return movimentacoesRepository.findAll();
	}
	
	public Movimentacoes gravarModificacao(Movimentacoes mov) {
		
		if(mov.getTipo().getCod() == 1) {
			
		
			Conta conta = contaRepository.findOne(mov.getCliente().getId());
			
			conta.setSaldo( 
					conta.getSaldo() - mov.getValor()
					);
			
			contaRepository.save(conta);
			
			
		}
		
		return null;
	}
	
	private void updateData(Conta newObj, Conta obj) {
		newObj.setSaldo(obj.getSaldo());
	}
}
