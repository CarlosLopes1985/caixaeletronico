package com.infogrupo.caixaeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogrupo.caixaeletronico.entity.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {

}
