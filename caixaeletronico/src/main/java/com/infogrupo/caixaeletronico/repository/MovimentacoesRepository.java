package com.infogrupo.caixaeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogrupo.caixaeletronico.entity.Movimentacoes;

@Repository
public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Integer> {

}
