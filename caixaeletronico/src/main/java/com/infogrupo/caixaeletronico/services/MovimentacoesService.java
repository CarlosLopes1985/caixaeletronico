package com.infogrupo.caixaeletronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogrupo.caixaeletronico.entity.Conta;
import com.infogrupo.caixaeletronico.entity.Movimentacoes;
import com.infogrupo.caixaeletronico.entity.dto.MovimentacoesDto;
import com.infogrupo.caixaeletronico.enums.TipoMovimentacao;
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
	
	public static Movimentacoes efetuarDeposito(Movimentacoes mov) {
		
		mov.getConta().setSaldo( 
				mov.getConta().getSaldo() + mov.getValor()
				);
		
		return mov;
	}
	
	public Movimentacoes gravarModificacao(MovimentacoesDto movDto) {
		
		Movimentacoes mov    = fromDto(movDto);
		Movimentacoes movObj = new Movimentacoes();
		
		movimentacoesRepository.save(mov);
		
		if(movDto.getTipo() == 1) {
			movObj = efetuarDeposito(mov);
		}else if(movDto.getTipo() == 2) {
			movObj = efetuarRetirada(mov);
		}else if(movDto.getTipo() == 3) {
			//movObj = efetuarTransferencia(mov);
		}
		
		contaRepository.save(movObj.getConta());
		
		return mov;
	}
	
	public static Movimentacoes efetuarRetirada(Movimentacoes mov) {
		
		mov.getConta().setSaldo( 
				mov.getConta().getSaldo() - mov.getValor()
				);
		
		return mov;
	}

	private Movimentacoes fromDto(MovimentacoesDto objDto) {
		
		Movimentacoes mov = new Movimentacoes();
		
		mov.setDataMovimentacao(objDto.getDataMovimentacao());
		mov.setTipo(TipoMovimentacao.toEnum(objDto.getTipo()));
		mov.setValor(objDto.getValor());
		
		Conta conta  = contaRepository.findOne(objDto.getIdConta()); 
		
		mov.setConta(conta);
		
		return mov;
	}
}
