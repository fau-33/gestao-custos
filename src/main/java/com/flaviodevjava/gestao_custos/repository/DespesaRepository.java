package com.flaviodevjava.gestao_custos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flaviodevjava.gestao_custos.entity.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, UUID> {

  List<Despesa> findByEmail(String email);

  List<Despesa> findByEmailAndData(String email, LocalDate data);

}
