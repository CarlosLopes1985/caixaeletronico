package com.infogrupo.caixaeletronico;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infogrupo.caixaeletronico.entity.Agencia;
import com.infogrupo.caixaeletronico.entity.Cliente;
import com.infogrupo.caixaeletronico.entity.Conta;
import com.infogrupo.caixaeletronico.entity.Movimentacoes;
import com.infogrupo.caixaeletronico.enums.TipoMovimentacao;
import com.infogrupo.caixaeletronico.repository.AgenciaRepository;
import com.infogrupo.caixaeletronico.repository.ClienteRepository;
import com.infogrupo.caixaeletronico.repository.ContaRepository;
import com.infogrupo.caixaeletronico.repository.MovimentacoesRepository;

@SpringBootApplication
public class CaixaeletronicoApplication implements CommandLineRunner{

	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private MovimentacoesRepository movimentacoesRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CaixaeletronicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Agencia a1 = new Agencia(null, 5666);
		Agencia a2 = new Agencia(null, 5266);
		
		agenciaRepository.save(Arrays.asList(a1,a2));
		
		Conta conta1 = new Conta(null, 8445, 100., a1);
		Conta conta2 = new Conta(null, 8445, 100., a2);
		
		contaRepository.save(Arrays.asList(conta1,conta2));
		
		Cliente c1 = new Cliente(null, "Carlos", "11792993706",conta1);
		Cliente c2 = new Cliente(null, "Renato", "11792993705",conta2);
		
		clienteRepository.save(Arrays.asList(c1,c2));
		
		Movimentacoes mo1 = new Movimentacoes(null, TipoMovimentacao.DEPOSITO, new Date(),100., c1);
		Movimentacoes mo2 = new Movimentacoes(null, TipoMovimentacao.RETIRADA, new Date(),120., c2);
		Movimentacoes mo3 = new Movimentacoes(null, TipoMovimentacao.DEPOSITO, new Date(),140., c1);
		Movimentacoes mo4 = new Movimentacoes(null, TipoMovimentacao.RETIRADA, new Date(),200., c2);
		Movimentacoes mo5 = new Movimentacoes(null, TipoMovimentacao.DEPOSITO, new Date(),600., c2);
		Movimentacoes mo6 = new Movimentacoes(null, TipoMovimentacao.RETIRADA, new Date(),300., c1);
		Movimentacoes mo7 = new Movimentacoes(null, TipoMovimentacao.TRANSFERENCIA, new Date(),520., c1);
		
		movimentacoesRepository.save(Arrays.asList(mo1,mo2,mo3,mo4,mo5,mo6,mo7));
		
	}

}
