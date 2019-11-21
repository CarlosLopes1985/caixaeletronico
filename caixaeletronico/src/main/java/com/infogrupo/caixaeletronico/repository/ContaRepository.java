package com.infogrupo.caixaeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogrupo.caixaeletronico.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
